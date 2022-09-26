public class RepeatedSubstring {
    /**
     * Link: https://leetcode.com/problems/repeated-substring-pattern/
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int strLen = s.length();
        if (strLen == 1) {
            return false;
        }
        for (int subStrLen = 1; subStrLen * subStrLen <= strLen; subStrLen++) {
            if (strLen % subStrLen == 0) {
                String subStr = s.substring(0, subStrLen);
                int secondSubStrLen = strLen / subStrLen;
                if (checkRepeatedSubPattern(secondSubStrLen, subStr, s) == false) {
                    if(secondSubStrLen != strLen){
                        subStr = s.substring(0, secondSubStrLen);
                        boolean secondSubstrRepeated = checkRepeatedSubPattern(subStrLen, subStr, s);
                        if (secondSubstrRepeated) {
                            return true;
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRepeatedSubPattern(int numOfSubStr, String subStr, String strToBuild) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int cnt = 0; cnt < numOfSubStr; cnt++) {
            stringBuilder.append(subStr);
        }
        if (stringBuilder.toString().equals(strToBuild)) {
            return true;
        } else {
            return false;
        }
    }
}
