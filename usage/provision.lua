done = false
err = nil
while done == false do
  node = peripheral.wrap("right")
  if node == nil then done = true
  else
    if node.isOn() == true
    then node.reboot()
    else node.turnOn() end
    e,f = turtle.forward()
    if e == false
    then
      turtle.refuel()
      e,f = turtle.forward()
    end
    if e ~= true then
      err = f
      done = true
    end
  end
end
if err ~= nil then print(err)
else print("Done!") end
