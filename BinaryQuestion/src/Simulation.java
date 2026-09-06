public class Simulation {
    public  String modifyString(String s) {
        char[] sss=s.toCharArray();
        for(int i=0;i<sss.length;i++) {
            char c = 'a';
            if (sss[i] == '?') {
                //判断？出现在字符串头部时
                if (i == 0) {
                    for (int j = 0; j < 26; j++) {
                        if (c != sss[i + 1]) {
                            sss[i] = c;
                            continue;
                        }
                        c++;
                    }
                    continue;
                }
                //判断？出现在字符串尾部
                if (i == sss.length - 1) {
                    for (int j = 0; j < 26; j++) {
                        if (c != sss[i - 1]) {
                            sss[i] = c;
                            continue;
                        }
                        c++;
                    }
                    continue;
                }
                //判断？出现在字符串中部
                for (int j = 0; j < 26; j++) {
                    if (c != sss[i - 1] && c != sss[i + 1]) {
                        sss[i] = c;
                        continue;
                    }
                    c++;
                }
            }
        }
        String aaa=new String(sss);
        return aaa;
    }
}
