require "string"

str1 = arg[1]
str2 = ""

for i = 1, str1:len() do
   local char = str1:sub(i, i)
   local up_char = char:upper()

   if up_char >= "A" and up_char <= "M" then
      char = string.char(char:byte() + 13)
   elseif up_char >= "N" and up_char <= "Z" then
      char = string.char(char:byte() - 13)
   end

   str2 = str2 .. char
end

print(str2)
