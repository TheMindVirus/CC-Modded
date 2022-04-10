w = 320
h = 240

x,y,z = gps.locate()
id = ((y - 1) * w) + (x - 1)

_G.mod = peripheral.wrap("back")
if _G.mod == nil then
  _G.mod = peripheral.wrap("front")
end
_G.mod.setNameLocal("node")
_G.mod.setIDLocal(id)

os.setComputerLabel(_G.mod.getNameLocal())
print(os.getComputerLabel())
