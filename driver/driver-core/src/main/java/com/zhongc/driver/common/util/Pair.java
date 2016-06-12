//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zhongc.driver.common.util;

public class Pair<F, S> {
    private final F f;
    private final S s;

    public static <F, S> Pair<F, S> build(F f, S s) {
        return new Pair(f, s);
    }

    public Pair(F k, S v) {
        this.f = k;
        this.s = v;
    }

    public F getF() {
        return this.f;
    }

    public S getS() {
        return this.s;
    }

    public int hashCode() {
        boolean prime = true;
        byte result = 1;
        int result1 = 31 * result + (this.f == null?0:this.f.hashCode());
        result1 = 31 * result1 + (this.s == null?0:this.s.hashCode());
        return result1;
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            Pair other = (Pair)obj;
            if(this.f == null) {
                if(other.f != null) {
                    return false;
                }
            } else if(!this.f.equals(other.f)) {
                return false;
            }

            if(this.s == null) {
                if(other.s != null) {
                    return false;
                }
            } else if(!this.s.equals(other.s)) {
                return false;
            }

            return true;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pair <").append(this.f).append(",").append(this.s).append(">");
        return builder.toString();
    }
}
