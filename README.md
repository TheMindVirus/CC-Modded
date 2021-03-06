# ![CC: Tweaked](doc/logo.png)
[![Current build status](https://github.com/cc-tweaked/CC-Tweaked/workflows/Build/badge.svg)](https://github.com/cc-tweaked/CC-Tweaked/actions "Current build status") [![Download CC: Tweaked on CurseForge](http://cf.way2muchnoise.eu/title/cc-tweaked.svg)][CurseForge]

![](https://github.com/TheMindVirus/CC-Modded/blob/main/src/main/resources/assets/computercraft/textures/block/computer_command_front.png) Built with [GitPod](https://gitpod.io/#https://github.com/cc-tweaked/CC-Tweaked/) (See [Building Instructions](https://github.com/TheMindVirus/CC-Modded/blob/main/CONTRIBUTING.md#developing) below for More Information) \
Full Changelog: https://github.com/TheMindVirus/CC-Modded/blob/main/cctweakedpatchnotes.txt
## New Features
```diff
- Red Computers!
- Red Peripherals!
- New Modem Commands!
```
https://github.com/TheMindVirus/CC-Modded/blob/380cb62da9d51ce13624b1a82357269c42e48dd4/src/main/java/dan200/computercraft/shared/peripheral/modem/wired/WiredModemPeripheral.java#L230

https://github.com/TheMindVirus/CC-Modded/blob/380cb62da9d51ce13624b1a82357269c42e48dd4/src/main/java/dan200/computercraft/shared/peripheral/modem/wired/WiredModemLocalPeripheral.java#L112

#### Textures: https://github.com/TheMindVirus/CC-Modded/tree/main/src/main/resources/assets/computercraft/textures/block/

#### New Commands:
```
mod = peripheral.wrap("back")
mod.getNameLocal()
mod.getNamesRemote()
mod.getIDLocal()
mod.setIDLocal(7)
mod.getTypeLocal()
mod.setNameLocal("router")
```

## Download
Direct Download: https://github.com/TheMindVirus/CC-Modded/raw/main/build/libs/cc-modded-1.18.2-1.100.4.jar \
Experimental*: https://github.com/TheMindVirus/CC-Modded/raw/main/build/libs/cc-modded-1.18.2-1.100.4A.jar \
CurseForge: https://www.curseforge.com/minecraft/mc-mods/cc-modded \
Build Artifacts: https://github.com/TheMindVirus/CC-Modded/tree/main/build/libs \
Source Code: https://github.com/TheMindVirus/CC-Modded/archive/refs/heads/main.zip

\* - this build has been patched by hand to allow Command Computers to boot from local disks by default. \
More Info: [ https://github.com/TheMindVirus/CC-Modded/issues/3 ](https://github.com/TheMindVirus/CC-Modded/issues/3)

## About
CC: Tweaked is a mod for Minecraft which adds programmable computers, turtles and more to the game. A fork of the
much-beloved [ComputerCraft], it continues its legacy with better performance, stability, and a wealth of new features.

CC: Tweaked can be installed from [CurseForge] or [Modrinth]. It requires the [Minecraft Forge][forge] mod loader, but
[versions are available for Fabric][ccrestitched].

## Contributing
Any contribution is welcome, be that using the mod, reporting bugs or contributing code. If you want to get started
developing the mod, [check out the instructions here](CONTRIBUTING.md#developing).

## Community
If you need help getting started with CC: Tweaked, want to show off your latest project, or just want to chat about
ComputerCraft we have a [forum](https://forums.computercraft.cc/) and [Discord guild](https://discord.computercraft.cc)!
There's also a fairly populated, albeit quiet [IRC channel](http://webchat.esper.net/?channels=computercraft), if that's
more your cup of tea.

We also host fairly comprehensive documentation at [tweaked.cc](https://tweaked.cc/ "The CC: Tweaked website").

## Using
CC: Tweaked is hosted on my maven repo, and so is relatively simple to depend on. You may wish to add a soft (or hard)
dependency in your `mods.toml` file, with the appropriate version bounds, to ensure that API functionality you depend
on is present.

```groovy
repositories {
  maven {
    url 'https://squiddev.cc/maven/'
    content {
      includeGroup 'org.squiddev'
    }
  }
}

dependencies {
  implementation fg.deobf("org.squiddev:cc-tweaked-${mc_version}:${cct_version}")
}
```

You should also be careful to only use classes within the `dan200.computercraft.api` package. Non-API classes are
subject to change at any point. If you depend on functionality outside the API, file an issue, and we can look into
exposing more features.

We bundle the API sources with the jar, so documentation should be easily viewable within your editor. Alternatively,
the generated documentation [can be browsed online](https://tweaked.cc/javadoc/).

[computercraft]: https://github.com/dan200/ComputerCraft "ComputerCraft on GitHub"
[curseforge]: https://minecraft.curseforge.com/projects/cc-tweaked "Download CC: Tweaked from CurseForge"
[modrinth]: https://modrinth.com/mod/gu7yAYhd "Download CC: Tweaked from Modrinth"
[forge]: https://files.minecraftforge.net/ "Download Minecraft Forge."
[ccrestitched]: https://www.curseforge.com/minecraft/mc-mods/cc-restitched "Download CC: Restitched from CurseForge"

## Screenshots
### Redpods
![redpods](https://github.com/TheMindVirus/CC-Modded/blob/main/redpods.png)
### Usage
![usage](https://github.com/TheMindVirus/CC-Modded/blob/main/usage.png)
### GitPod
![gitpod](https://github.com/TheMindVirus/CC-Modded/blob/main/gitpod.png)
