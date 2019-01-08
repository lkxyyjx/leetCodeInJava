public class S006 {
    public static void main(String[] args) {
        S006 hw = new S006();
        System.out.println(hw.convert("A", 1));
    }

    public String convert(String s, int numRows) {
        int colOfZqueneRow;
        String res = "";
        int len = s.length();
        if (numRows == 1 || numRows == 0) {
            return  s;
        }
        for (int i = 0; i < numRows; i++) {
            colOfZqueneRow = 0;
            if (i == 0) {
                while (2 * colOfZqueneRow * (numRows - 1) < len) {
                    res += s.charAt(2 * colOfZqueneRow * (numRows - 1));
                    colOfZqueneRow++;
                }
            } else if (i == numRows - 1) {
                while ((2 * colOfZqueneRow + 1) * (numRows - 1) < len) {
                    res += s.charAt((2 * colOfZqueneRow + 1) * (numRows - 1));
                    colOfZqueneRow++;
                }
            } else {
                while (2 * colOfZqueneRow * (numRows - 1) + i < len) {
                    res += s.charAt(2 * colOfZqueneRow * (numRows - 1) + i);
                    if (2 * (colOfZqueneRow + 1) * (numRows - 1) - i < len) {
                        res += s.charAt(2 * (colOfZqueneRow + 1) * (numRows - 1) - i);
                    }
                    colOfZqueneRow++;
                }
            }
        }
        return res;
    }
}
