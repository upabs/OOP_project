package com.javalab.models;

public class UnitTest {
    public static void main(String[] args) {
        // ko phai HHCN
        ToaDo a1 = new ToaDo(0,0,0);
        ToaDo b1 = new ToaDo(2,1,0);
        ToaDo d1 = new ToaDo(0,2,0);
        HinhHopChuNhat hinhHopChuNhat1 = new HinhHopChuNhat(a1,b1,d1,4);
        System.out.println(hinhHopChuNhat1.laHinhHopChuNhat());
        System.out.println(hinhHopChuNhat1.theTich());
        System.out.println();
        // la HHCN
        ToaDo a = new ToaDo(0,0,0);
        ToaDo b = new ToaDo(2,0,0);
        ToaDo d = new ToaDo(0,2,0);
        System.out.println(a.khoangCach(b));
        HinhHopChuNhat hinhHopChuNhat = new HinhHopChuNhat(a,b,d,3);
        System.out.println(hinhHopChuNhat.theTich());

        ToaDo o = new ToaDo(1,3,1);
        System.out.println(hinhHopChuNhat.phanLoaiDiem(o));

        ToaDo o1 = new ToaDo(1,1,1);
        System.out.println(hinhHopChuNhat.phanLoaiDiem(o1));
    }

}
