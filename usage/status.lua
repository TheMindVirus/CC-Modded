mod = peripheral.wrap("back")
nod = mod.getNamesRemote()
chk = true
pix = 320 * 240

function has_value(arr, val)
  for i,v in ipairs(arr) do
    if v == val then return true end
  end
  return false
end

for i = 0,pix,1 do
  lbl = "node_" .. tostring(i)
  if not has_value(nod, lbl) then
    chk = false
    print(lbl .. " is missing")
  end
end
if chk then print("OK") end
