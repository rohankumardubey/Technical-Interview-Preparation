package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a fence with n posts and k colors, find out the number of ways of painting the fence such
 * that at most 2 adjacent posts have the same color.
 * <p>
 * Since answer can be large return it modulo 10^9 + 7.
 */
public class PaintingTheFence {

    private static long paint(int n, int k) {
        // For the first two posts, there are two ways to paint.
        // 1. Taking both the colors same. Therefore, if we have
        // k choices to paint the first post, then we have the same
        // choices to paint the second post because we need to keep
        // same colors.
        // 2. Taking different colors. Here, we have total k * (k - 1)
        // choices => k choices for the first post and (k - 1) choices
        // for the second post because we cannot use the same colors
        // TOTAL => k + k * (k - 1) for first two fences
        // From the above -
        int same = k;
        int different = k * (k - 1);
        long total = same + different;
        // Populate the table for remaining posts
        for (int i = 3; i <= n; i++) {
            // Now, we have two choices for every post, choosing same
            // colors and choosing different colors
            // If we choose to have the same colors, then the number of
            // combinations of previous post will be the same for this
            // post. We cannot choose same of previous post for the same
            // of this post because it will violate the condition of having
            // only two consecutive posts with same color
            same = different;
            // We we choose to have different colors, then we will have
            // to choose total of previous post times (k - 1)
            different = (int) total * (k - 1);
            different %= 1000000007;
            // Store this total in the current index of lookup
            total = (same + different) % 1000000007;
        }
        return total;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        System.out.println(paint(n, k));

        n = 2;
        k = 4;
        System.out.println(paint(n, k));
    }
}
