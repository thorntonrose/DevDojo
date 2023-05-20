require "string"

str1 = arg[1]
str2 = ""

for i = 1, string.len(str1) do
   local char = string.sub(str1, i, i)
   local up_char = string.upper(char)

   if up_char >= "A" and up_char <= "M" then
      char = string.char(string.byte(char) + 13)
   elseif up_char >= "N" and up_char <= "Z" then
      char = string.char(string.byte(char) - 13)
   end

   str2 = str2 .. char
end

print(str2)
