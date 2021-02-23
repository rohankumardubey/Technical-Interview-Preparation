/**
 * @author Anirudh Sharma
 * 
 * Given a string, we have to find out all subsequences of it. A String is a subsequence of a given String,
 * that is generated by deleting some character of a given string without changing its order.
 */
const findSubsequences = (s) => {
    // Array to store the result
    const subsequences = [];
    findSubsequencesHelper(s, "", subsequences);
    return subsequences;
};

const findSubsequencesHelper = (s, current, subsequences) => {
    // Base case
    if (s.length === 0) {
        subsequences.push(current);
        return;
    }
    // Include first character
    findSubsequencesHelper(s.substring(1), current + s.charAt(0), subsequences);
    // Skip first character
    findSubsequencesHelper(s.substring(1), current, subsequences);
};

const main = () => {
    console.log(findSubsequences("Hello"));
    console.log(findSubsequences("abcd"));
};

main();