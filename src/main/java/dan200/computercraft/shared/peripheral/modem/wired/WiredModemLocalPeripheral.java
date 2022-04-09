/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2022. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */
package dan200.computercraft.shared.peripheral.modem.wired; //^^ this and compilation is why nothing happened.

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.shared.Peripherals;
import dan200.computercraft.shared.Registry;
import dan200.computercraft.shared.util.IDAssigner;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.util.NonNullConsumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Map;

/**
 * Represents a local peripheral exposed on the wired network.
 *
 * This is responsible for getting the peripheral in world, tracking id and type and determining whether
 * it has changed.
 */
public final class WiredModemLocalPeripheral
{
    private static final String NBT_PERIPHERAL_ID = "PeripheralId";
    private static final String NBT_PERIPHERAL_TYPE = "PeripheralType";
    private static final String NBT_PERIPHERAL_NAME = "PeripheralName"; ///!!! WHY WAS THIS MISSING !!!///

    private int id = -1;
    private String type;
    private String name; ///!!! WHY WAS THIS MISSING !!!///

    private IPeripheral peripheral;
    private final NonNullConsumer<Object> invalidate;

    public WiredModemLocalPeripheral( @Nonnull Runnable invalidate )
    {
        this.invalidate = x -> invalidate.run();
    }

    /**
     * Attach a new peripheral from the world.
     *
     * @param world     The world to search in
     * @param origin    The position to search from
     * @param direction The direction so search in
     * @return Whether the peripheral changed.
     */
    public boolean attach( @Nonnull Level world, @Nonnull BlockPos origin, @Nonnull Direction direction )
    {
        IPeripheral oldPeripheral = peripheral;
        IPeripheral peripheral = this.peripheral = getPeripheralFrom( world, origin, direction );

        if( peripheral == null )
        {
            return oldPeripheral != null;
        }
        else
        {
            String type = peripheral.getType();
            int id = this.id;

            if( id > 0 && this.type == null )
            {
                // If we had an ID but no type, then just set the type.
                this.type = type;
            }
            else if( id < 0 || !type.equals( this.type ) )
            {
                this.type = type;
                this.id = IDAssigner.getNextId( "peripheral." + type );
            }

            if ( this.name == null ) //Both the newline rule and the whitespace rule shouldn't be applied here - this sucks, change it back
            {
                this.name = type;
            }

            return oldPeripheral == null || !oldPeripheral.equals( peripheral );
        }
    }

    /**
     * Detach the current peripheral.
     *
     * @return Whether the peripheral changed
     */
    public boolean detach()
    {
        if( peripheral == null ) return false;
        peripheral = null;
        return true;
    }

    @Nullable
    public String getConnectedName()
    {
        //return peripheral != null ? type + "_" + id : null;
        return peripheral != null ? name + "_" + id : null;
    }

    ///!!! WHY WAS THIS MISSING !!!///
    @Nullable
    public String getConnectedType()
    {
        return peripheral != null ? type : null;
    }

    @Nullable
    public String setConnectedID( @Nonnull int newid ) //This "decorated" syntax sucks, change it back
    {
        id = newid;
        return peripheral != null ? name + "_" + id : null;
    }

    @Nullable
    public String setConnectedName( @Nonnull String newname ) //This "decorated" syntax sucks, change it back
    {
        name = newname;
        return peripheral != null ? name + "_" + id : null;
    }
    ///!!! WHY WAS THIS MISSING !!!///

    @Nullable
    public IPeripheral getPeripheral()
    {
        return peripheral;
    }

    public boolean hasPeripheral()
    {
        return peripheral != null;
    }

    public void extendMap( @Nonnull Map<String, IPeripheral> peripherals )
    {
        //if( peripheral != null ) peripherals.put( type + "_" + id, peripheral );
        if( peripheral != null ) peripherals.put( name + "_" + id, peripheral );
        //Needs Curly Braces to allow multiple macros but newline rule prevents it - This sucks, change it back
    }

    public Map<String, IPeripheral> toMap()
    {
        return peripheral == null
            ? Collections.emptyMap()
            : Collections.singletonMap( name + "_" + id, peripheral ); //: Collections.singletonMap( type + "_" + id, peripheral );
    }

    public void write( @Nonnull CompoundTag tag, @Nonnull String suffix )
    {
        if( id >= 0 ) tag.putInt( NBT_PERIPHERAL_ID + suffix, id );
        if( type != null ) tag.putString( NBT_PERIPHERAL_TYPE + suffix, type );
        if( name != null ) tag.putString( NBT_PERIPHERAL_NAME + suffix, name );
        //Needs Curly Braces to allow multiple macros but newline rule prevents it - This sucks, change it back
    }

    public void read( @Nonnull CompoundTag tag, @Nonnull String suffix )
    {
        id = tag.contains( NBT_PERIPHERAL_ID + suffix, Tag.TAG_ANY_NUMERIC )
            ? tag.getInt( NBT_PERIPHERAL_ID + suffix ) : -1;

        type = tag.contains( NBT_PERIPHERAL_TYPE + suffix, Tag.TAG_STRING )
            ? tag.getString( NBT_PERIPHERAL_TYPE + suffix ) : null;

        name = tag.contains( NBT_PERIPHERAL_NAME + suffix, Tag.TAG_STRING )
            ? tag.getString( NBT_PERIPHERAL_NAME + suffix ) : null;
    }

    @Nullable
    private IPeripheral getPeripheralFrom( Level world, BlockPos pos, Direction direction )
    {
        BlockPos offset = pos.relative( direction );

        Block block = world.getBlockState( offset ).getBlock();
        if( block == Registry.ModBlocks.WIRED_MODEM_FULL.get() || block == Registry.ModBlocks.CABLE.get() ) return null;

        IPeripheral peripheral = Peripherals.getPeripheral( world, offset, direction.getOpposite(), invalidate );
        return peripheral instanceof WiredModemPeripheral ? null : peripheral;
    }
}
