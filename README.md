# StringCalculator

*Before you start*: 
- Try not to read ahead.
- Do one task at a time. The trick is to learn to work incrementally.

Implement a simple String calculator with a method `int add(string numbersStr)`:

- The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) for example "" or "1" or "1,2"
Start with the simplest test case of an empty string and move to 1 and two numbers.

Remember to solve things as simply as possible so that you force yourself to write tests you did not think about.  
Remember to refactor after each passing test.

Once you are done with _1_, proceed with the following:

- Allow the `add` method to handle an unknown amount of numbers
- Allow the `add` method to handle new lines between numbers (instead of commas). Example, the following input is ok:  “1\n2,3”  (will equal 6). But the following input is _NOT_ ok:  “1,\n”
- Support different delimiters. To change a delimiter, the beginning of the string will contain a separate line that looks like this:   "//[delimiter]\n[numbers…]". For example, "//;\n1;2" should return 3 where the default delimiter is ";". The first line is optional. All existing scenarios should still be supported
- Calling Add with a negative number will throw `StringCalculatorException`
- Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2
- Delimiters can be of any length with the following format:  "//[delimiter]\n". For example: "//[***]\n1***2***3" should return 6
- Allow multiple delimiters like this:  "//[delim1][delim2]\n". For example "//[*][%]\n1*2%3" should return 6
- Make sure you can also handle multiple delimiters with length longer than one char
