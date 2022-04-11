for i = 2,100,1 do
  rel = "1 "..tostring(i).." 1"
  commands.exec("clone 1 1 1 100 1 1 "..rel)
  --if true then break end
  os.sleep(10)
end
print("Done!")
