require "string"

if #arg < 1 then
   print("usage: stairs <num>")
else
   local count = arg[1]

   for i = 1, count do
      local stair = ("#"):rep(i)
      print((" "):rep(count - stair:len()) .. stair)
   end
end
