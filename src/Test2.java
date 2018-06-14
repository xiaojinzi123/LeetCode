public class Test2 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(7);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);

        ListNode result = addTwoNumbers(l1, l2);

        while (result != null) {

            System.out.print(result.val);
            result = result.next;

        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            l1 = new ListNode(0);
        }

        if (l2 == null) {
            l2 = new ListNode(0);
        }

        ListNode p = l1, q = l2, result = null,currResult = null;

        boolean isBiggerThanNine = false;

        while (p != null || q != null) {

            int tmpResult = (p == null ? 0 : p.val) + (q == null ? 0 : q.val);

            if (isBiggerThanNine) { // 进位的
                tmpResult++;
            }

            isBiggerThanNine = tmpResult > 9;

            if (currResult == null) {
                currResult = new ListNode(0);
                if (result == null) {
                    result = currResult;
                }
            }else {
                currResult.next = new ListNode(0);
                currResult = currResult.next;
            }

            currResult.val = tmpResult % 10;

            p = p == null ? null : p.next;
            q = q == null ? null : q.next;

        }

        if (isBiggerThanNine) {
            currResult.next = new ListNode(1);
        }

        return result;

    }

}
