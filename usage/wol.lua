local args = {...}
power = 1
if args[1] == "off" then power = 0 end
if power == 1 then print("[BOOT]: Powering On...")
else print("[BOOT]: Shutting Down...") end

pix = 320 * 240
for n = 0,pix,1 do
  lbl = "node_" .. tostring(n)
  nod = peripheral.wrap(lbl)
  if nod ~= nil then
    if power == 1 then nod.turnOn()
    else nod.shutdown() end
  end
end

print("[INFO]: Done!")
