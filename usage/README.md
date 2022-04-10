# Cluster Usage
![screenshot](../redpods.png)
# Wake On LAN: [WakeOnLAN.mp4](./WakeOnLAN.mp4)
# Provisioning a Node: [NodeProvisioning.mp4](./NodeProvisioning.mp4)
# Hidden Settings
```
Some computer settings have been authoritatively hidden from the source tree \
and are only applied in cloud build of the mod. This has been made obvious by \
the custom deepsearch.py tool vs. GitHub and the poor coding style enforcements. \
Options in `config/computercraft-client.toml` are also being blanked authoritatively.

If you want your cluster to boot from disk, the only known workaround is to \
build one layer of advanced computers as a control plane and an adjacent layer \
of command computers directly attached as a command plane. This will be slower. \
Otherwise, every node has to be provisioned manually.

A custom build which completely ignores this setting in the lua bios is another \
way to workaround the issue but it requires recompilation.
```
# WorldEdit
```py
Build Cluster

//pos1 1,1,1
//pos2 320,240,1
//set computercraft:computer_command

Build Modem and Cables (front side)

//pos1 1,1,0
//pos2 1,2,0
//copy

//pos1 1,1,0
//pos2 320,240,0
//set #clipboard

Build Modem and Cables (back side)

//pos1 1,1,2
//pos2 1,2,2
//copy

//pos1 1,1,2
//pos2 320,240,2
//set #clipboard@[0,-1,0]

Build Interconnect between Switches

Add Command Node and Disk Drive

Insert Disk into Disk Drive

Boot Command Node and Edit Scripts

Provision Nodes and Wake On LAN

Group Select and Call Remote
```
