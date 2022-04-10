mod = peripheral.wrap("back")
nod = mod.getNamesRemote()
cnt = 0
pix = 320 * 240
for i,v in ipairs(nod) do cnt = cnt + 1 end
msg = tostring(cnt)
msg = msg .. " nodes provisioned out of "
msg = msg .. tostring(pix)
print(msg)
