require "string"

function rot13_char(char)
   local up_char = char:upper()

   if up_char >= "A" and up_char <= "M" then
      return string.char(char:byte() + 13)
   end

   if up_char >= "N" and up_char <= "Z" then
      return string.char(char:byte() - 13)
   end

   return char
end

function rot13(str)
   local rot_str = ""

   for i = 1, str:len() do
      rot_str = rot_str .. rot13_char(str:sub(i, i))
   end

   return rot_str
end

print(rot13(arg[1]))
