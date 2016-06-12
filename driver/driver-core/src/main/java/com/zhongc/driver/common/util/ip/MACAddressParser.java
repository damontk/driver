//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zhongc.driver.common.util.ip;

public final class MACAddressParser {
    private MACAddressParser() {
    }

    static String parse(String in) {
        String out = in;
        int hexStart = in.indexOf("0x");
        int var7;
        if(hexStart != -1 && in.indexOf("ETHER") != -1) {
            var7 = in.indexOf(32, hexStart);
            if(var7 > hexStart + 2) {
                out = in.substring(hexStart, var7);
            }
        } else {
            byte octets = 0;
            if(in.indexOf(58) > -1) {
                out = in.replace(':', '-');
            }

            int lastIndex = out.lastIndexOf(45);
            if(lastIndex > out.length() - 2) {
                out = null;
            } else {
                int end = Math.min(out.length(), lastIndex + 3);
                var7 = octets + 1;
                int old = lastIndex;

                label49:
                while(true) {
                    do {
                        if(var7 == 5 || lastIndex == -1 || lastIndex <= 1) {
                            if(var7 == 5 && lastIndex > 1) {
                                out = out.substring(lastIndex - 2, end).trim();
                            } else {
                                out = null;
                            }
                            break label49;
                        }

                        --lastIndex;
                        lastIndex = out.lastIndexOf(45, lastIndex);
                    } while(old - lastIndex != 3 && old - lastIndex != 2);

                    ++var7;
                    old = lastIndex;
                }
            }
        }

        if(out != null && out.startsWith("0x")) {
            out = out.substring(2);
        }

        return out;
    }
}
