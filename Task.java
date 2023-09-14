class PalindromicDates {
    public static void main(String[] args) {
        printBonusDatesBetween(2000, 2023);
    }

    public static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        for (int i = fromYear; i <= toYear; i++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                        continue;
                    } else if (month == 2) {
                        if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                            if (day > 29) {
                                continue;
                            }
                        } else if (day > 28) {
                            continue;
                        }
                    } else if (day > 31) {
                        continue;
                    }

                    String dateStr = String.format("%04d%02d%02d", i, month, day);

                    if (isPalindrome(dateStr)) {
                        if(month < 10 && day < 10){
                            System.out.println(i + "-" + 0 + month + "-" + 0 + day);
                        } else if(month >=10 && day < 10){
                            System.out.println(i + "-" + month + "-" + 0 + day);
                        } else if(month < 10 && day >= 10){
                            System.out.println(i + "-" + 0 + month + "-" + day);
                        }
                    }
                }
            }
        }
    }
}