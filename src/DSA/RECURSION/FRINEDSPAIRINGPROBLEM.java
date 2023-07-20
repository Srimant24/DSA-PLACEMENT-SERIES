package DSA.RECURSION;

public class FRINEDSPAIRINGPROBLEM {
    public static int pairFriends(int n) {
        if(n <= 1) {
            return 1;
        }

        return pairFriends(n-1) + (n-1) * pairFriends(n-2);
    }
}
