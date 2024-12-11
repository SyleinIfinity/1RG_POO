public class hinhTron {
    private double banKinh;

    public hinhTron(double banKinh) 
    {
        if (banKinh <= 0) 
        {
            throw new IllegalArgumentException("Ban kinh phai lon hon 0!");
        }
        this.banKinh = banKinh;
    }
    public void tinhChuViVaDienTich() 
    {
        System.out.println("Chu vi: " + (2 * Math.PI * banKinh));
        System.out.println("Dien tich: " + (Math.PI * banKinh * banKinh));
    }
}