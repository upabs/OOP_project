package com.javalab.models;

import com.javalab.constant.AppConstant;

public class HinhHopChuNhat {
    // HHCN ABCDA'B'C'D'
    public ToaDo[] cacDinh = new ToaDo[8];
    // a[0] = A, a[1] = B, a[2] = C, a[3] = D
    // a[4] = A', a[5] = B', a[6] = C', a[7] = D'
    public double chieuCao;
    public MatPhang[] cacMatPhang = new MatPhang[6];
    // cacMatPhang[0] = ABCD, cacMatPhang[1] = A'B'C'D'
    // cacMatPhang[2] = ABB'A' cacMatPhang[3] = BCC'B'
    // cacMatPhang[4] = CDD'C' cacMatPhang[5] = DAA'D'

//    0
//    A       D
//    -----------> y
//    |  Đáy |
//    |  Vật |
//  B |------|C
//    |
//    x
    public HinhHopChuNhat() {
    }

    // phải nhập góc vuông -> 2 đỉnh 2 bên -> chiều cao #A,B,D
    public HinhHopChuNhat(ToaDo a,ToaDo b,ToaDo d,double chieuCao) {
        for (int i = 0; i < cacDinh.length; i++) {
            cacDinh[i] = new ToaDo();
        }
        this.cacDinh[0] = a; // A
        this.cacDinh[1] = b; // B
        this.cacDinh[3] = d; //D
        this.chieuCao = chieuCao;
        // C
        this.cacDinh[2].setX(cacDinh[1].getX()-cacDinh[0].getX()+cacDinh[3].getX());
        this.cacDinh[2].setY(cacDinh[1].getY()-cacDinh[0].getY()+cacDinh[3].getY());
        this.cacDinh[2].setZ(cacDinh[1].getZ()-cacDinh[0].getZ()+cacDinh[3].getZ());
        // A'
        this.cacDinh[4].setZ(cacDinh[0].getZ() + chieuCao);
        this.cacDinh[4].setX(cacDinh[0].getX());
        this.cacDinh[4].setY(cacDinh[0].getY());
        // B'
        this.cacDinh[5].setZ(cacDinh[1].getZ() + chieuCao);
        this.cacDinh[5].setX(cacDinh[1].getX());
        this.cacDinh[5].setY(cacDinh[1].getY());
        // C'
        this.cacDinh[6].setZ(cacDinh[2].getZ() + chieuCao);
        this.cacDinh[6].setX(cacDinh[2].getX());
        this.cacDinh[6].setY(cacDinh[2].getY());
        // D'
        this.cacDinh[7].setZ(cacDinh[3].getZ() + chieuCao);
        this.cacDinh[7].setX(cacDinh[3].getX());
        this.cacDinh[7].setY(cacDinh[3].getY());

        for (int i = 0; i < cacMatPhang.length; i++) {
            cacMatPhang[i] = new MatPhang();
        }
        // ABCD
        cacMatPhang[0].setDiemThuoc(cacDinh[0]);
        ToaDo t = HinhHopChuNhat.tichCoHuong(vector(this.cacDinh[0],this.cacDinh[1]),vector(this.cacDinh[0],cacDinh[2]));
        cacMatPhang[0].setPhapTuyen(tichCoHuong(vector(cacDinh[0],cacDinh[1]),vector(cacDinh[0],cacDinh[2]))); // AB-> * AC->
        // A'B'C'D'
        cacMatPhang[1].setDiemThuoc(cacDinh[4]);
        cacMatPhang[1].setPhapTuyen(tichCoHuong(vector(cacDinh[4],cacDinh[5]),vector(cacDinh[4],cacDinh[6]))); // A'B'-> * A'C'->
        // ABB'A'
        cacMatPhang[2].setDiemThuoc(cacDinh[0]);
        cacMatPhang[2].setPhapTuyen(tichCoHuong(vector(cacDinh[0],cacDinh[1]),vector(cacDinh[0],cacDinh[4])));
        // BCC'B'
        cacMatPhang[3].setDiemThuoc(cacDinh[1]);
        cacMatPhang[3].setPhapTuyen(tichCoHuong(vector(cacDinh[1],cacDinh[2]),vector(cacDinh[1],cacDinh[5])));
        // CDD'C'
        cacMatPhang[4].setDiemThuoc(cacDinh[2]);
        cacMatPhang[4].setPhapTuyen(tichCoHuong(vector(cacDinh[2],cacDinh[3]),vector(cacDinh[2],cacDinh[6])));
        // DAA'D'
        cacMatPhang[5].setDiemThuoc(cacDinh[3]);
        cacMatPhang[5].setPhapTuyen(tichCoHuong(vector(cacDinh[3],cacDinh[0]),vector(cacDinh[3],cacDinh[4])));
    }
    public static ToaDo vector(ToaDo a, ToaDo b) {
        // vector ab;
        ToaDo x = new ToaDo();
        x.setX(b.getX() - a.getX());
        x.setY(b.getY() - a.getY());
        x.setZ(b.getZ() - a.getZ());
        return x;
    }

    public static ToaDo tichCoHuong(ToaDo a, ToaDo b) {
        ToaDo w = new ToaDo();

        // y1*z2 - y2*z1
        w.setX(a.getY()*b.getZ() - a.getZ()*b.getY());

        // z1*x2 - z2*x1
        w.setY(a.getZ()*b.getX() - a.getX()*b.getZ());

        // x1*y2 - x2*y1
        w.setZ(a.getX()*b.getY() - a.getY()*b.getX());

        return w;
    }
    public static double tichVoHuong(ToaDo a, ToaDo b) {
        return a.getX()*b.getX() + a.getY()*b.getY() + a.getZ()*b.getZ();
    }
    public static double doDaiVector(ToaDo a) {
        return Math.sqrt(a.getX()*a.getX() + a.getY()*a.getY() + a.getZ()*a.getZ());
    }
    public static double khoangCachMotDiemDenMotMatPhang(ToaDo x, MatPhang mat) {
        ToaDo n = mat.getPhapTuyen();
        ToaDo m = mat.getDiemThuoc();

        // pt mp: a(x-x0) + b(y-y0) + c(z-z0) = 0
        // d = -a*x0 - b*y0-c*z0
        double d = -n.getX()*m.getX() -n.getY()*n.getY() - n.getZ()*m.getZ();
        double tuSo = Math.abs(n.getX()*(x.getX()-m.getX()) + n.getY()*(x.getY()-m.getY()) + n.getZ()*(x.getZ()-m.getZ()));

        // sqrt(a^2 + b^2 + c^2)
        double mauSo = doDaiVector(n);

        if (mauSo == 0) {
            return -1;
        }

        return tuSo/mauSo;
    }
    public Double theTich() {
        if (laHinhHopChuNhat()) {
            double AB = cacDinh[0].khoangCach(cacDinh[1]);
            double AD = cacDinh[0].khoangCach(cacDinh[3]);
            double AA2 = cacDinh[0].khoangCach(cacDinh[4]);
            return AB*AD*AA2;
        }
        return 0.0;
    }

    // vị trí là tâm của đáy HHCN
    public ToaDo viTri() {
        ToaDo x = new ToaDo();
        x.setX((cacDinh[0].getX()+cacDinh[2].getX())/2);
        x.setY((cacDinh[0].getY()+cacDinh[2].getY())/2);
        x.setZ((cacDinh[0].getZ()+cacDinh[2].getZ())/2);
        return x;
    }

    public boolean laHinhHopChuNhat() {
        ToaDo a = HinhHopChuNhat.vector(cacDinh[0],cacDinh[1]);
        ToaDo b = HinhHopChuNhat.vector(cacDinh[0],cacDinh[3]);
        if(HinhHopChuNhat.tichVoHuong(a,b) == 0)
        {
            return true;
        }
        return false;
    }

    public static double dientichHCN(ToaDo a,ToaDo b,ToaDo c){
        //AB * AC
        return a.khoangCach(b)*a.khoangCach(c);
    }
    // xác định điểm O thuộc hay ko thuộc vật thể
    public boolean phanLoaiDiem(ToaDo o) {
        double thetich6chop = 0;
        double thetichvatthe = 0;

        // OABCD
        double OABCD = 1/3.0*khoangCachMotDiemDenMotMatPhang(o,cacMatPhang[0])*dientichHCN(cacDinh[0],cacDinh[1],cacDinh[3]);
        double OA2B2C2D2 = 1/3.0*khoangCachMotDiemDenMotMatPhang(o,cacMatPhang[1])*dientichHCN(cacDinh[4],cacDinh[5],cacDinh[7]);
        double OABB2A2 = 1/3.0*khoangCachMotDiemDenMotMatPhang(o,cacMatPhang[2])*dientichHCN(cacDinh[0],cacDinh[1],cacDinh[4]);
        double OBCC2B2 = 1/3.0*khoangCachMotDiemDenMotMatPhang(o,cacMatPhang[3])*dientichHCN(cacDinh[1],cacDinh[2],cacDinh[5]);
        double OCDD2C2 = 1/3.0*khoangCachMotDiemDenMotMatPhang(o,cacMatPhang[4])*dientichHCN(cacDinh[2],cacDinh[3],cacDinh[6]);
        double ODAA2D2 = 1/3.0*khoangCachMotDiemDenMotMatPhang(o,cacMatPhang[5])*dientichHCN(cacDinh[3],cacDinh[0],cacDinh[7]);
        thetich6chop = OABCD+OA2B2C2D2+OABB2A2+OBCC2B2+OCDD2C2+ODAA2D2;
        thetichvatthe = theTich();
        if(thetich6chop == thetichvatthe){
            return true;
        }
        return false;
    }

    public void chieu() {

    }
}
