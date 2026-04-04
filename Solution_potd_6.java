class Solution_potd_6 {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            int gray = i ^ (i >> 1);
            result.add(String.format("%" + n + "s", 
                Integer.toBinaryString(gray)).replace(' ', '0'));
        }
        return result;
    }
}