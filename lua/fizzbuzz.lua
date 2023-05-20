for i = 1, 15, 1 do
   -- if i % 3 == 0 and i % 5 == 0 then
   --    print(i, "fizzbuzz")
   -- elseif i % 3 == 0 then
   --    print(i, "fizz")
   -- elseif i % 5 == 0 then
   --    print(i, "buzz")
   -- end

   -- local fizz = i % 3 == 0 and "fizz" or ""
   -- local buzz = i % 5 == 0 and "buzz" or ""
   -- if (fizz ~= "" or buzz ~= "") then print(i, fizz .. buzz) end

   local text = (i % 3 == 0 and "fizz" or "") .. (i % 5 == 0 and "buzz" or "")
   if text ~= "" then print(i, text) end
end
