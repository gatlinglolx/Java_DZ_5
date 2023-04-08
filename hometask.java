import java.util.Deque;
import java.util.LinkedList;

public class hometask {
    public static void main(String[] args) {
        System.out.println(isCorrectParentheses("()")); // true
        System.out.println(isCorrectParentheses("(")); // false
        System.out.println(isCorrectParentheses("())")); // false
        System.out.println(isCorrectParentheses("((()))")); // true
        System.out.println(isCorrectParentheses("()[]{}<>")); // true
        System.out.println(isCorrectParentheses("([)]")); // false
        System.out.println(isCorrectParentheses("][]")); // false
        System.out.println("[]{<()[]<>>}"); // true
    }
        // Дана последовательность скобочек. Проверить, что она является корректной.

    static boolean isCorrectParentheses(String parentheses) {
            // Нужно завести маппинг скобочек либо ( -> ), либо ) -> ( и так для каждой пары
            // Нужно использовать Deque.
            // Открывающуюся скобку вносим в Deque (insertFirst)
            // Если встретилась закрывающаяся скобка, то (Deque#pollFirst) и сравниваем ее с встретившейся

        Deque<Character> deque = new LinkedList<>();
        for (char ch : parentheses.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '(' || ch == '<') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty()
                && ((deque.peekFirst() == '{' && ch == '}')
                || (deque.peekFirst() == '[' && ch == ']')
                || (deque.peekFirst() == '<' && ch == '>')
                || (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.pollFirst();
                } else {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
