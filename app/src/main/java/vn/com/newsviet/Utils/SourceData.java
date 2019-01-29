package vn.com.newsviet.Utils;

import java.util.ArrayList;

import vn.com.newsviet.model.News;

public class SourceData {
    public static ArrayList<News> getDataTabExpress() {
        ArrayList<News> arrayListTabExpress = new ArrayList();
        arrayListTabExpress.add(new News("Trang chủ", "https://vnexpress.net/rss/tin-moi-nhat.rss"));
        arrayListTabExpress.add(new News("Thời sự", "https://vnexpress.net/rss/thoi-su.rss"));
        arrayListTabExpress.add(new News("Thế giới", "https://vnexpress.net/rss/the-gioi.rss"));
        arrayListTabExpress.add(new News("Kinh doanh", "https://vnexpress.net/rss/kinh-doanh.rss"));
        arrayListTabExpress.add(new News("Startup", "https://vnexpress.net/rss/startup.rss"));
        arrayListTabExpress.add(new News("Giải trí", "https://vnexpress.net/rss/giai-tri.rss"));
        arrayListTabExpress.add(new News("Thể thao", "https://vnexpress.net/rss/the-thao.rss"));
        arrayListTabExpress.add(new News("Pháp luật", "https://vnexpress.net/rss/phap-luat.rss"));
        arrayListTabExpress.add(new News("Giáo dục", "https://vnexpress.net/rss/giao-duc.rss"));
        arrayListTabExpress.add(new News("Sức khỏe", "https://vnexpress.net/rss/suc-khoe.rss"));
        arrayListTabExpress.add(new News("Đời sống", "https://vnexpress.net/rss/gia-dinh.rss"));
        arrayListTabExpress.add(new News("Du lịch", "https://vnexpress.net/rss/du-lich.rss"));
        arrayListTabExpress.add(new News("Khoa học", "https://vnexpress.net/rss/khoa-hoc.rss"));
        arrayListTabExpress.add(new News("Số hóa", "https://vnexpress.net/rss/so-hoa.rss"));
        arrayListTabExpress.add(new News("Xe", "https://vnexpress.net/rss/oto-xe-may.rss"));
        arrayListTabExpress.add(new News("Cộng đồng", "https://vnexpress.net/rss/cong-dong.rss"));
        arrayListTabExpress.add(new News("Tâm sự", "https://vnexpress.net/rss/tam-su.rss"));
        arrayListTabExpress.add(new News("Cười", "https://vnexpress.net/rss/cuoi.rss"));
        return arrayListTabExpress;
    }

    public static ArrayList<News> getDataTab24h() {
        ArrayList<News> arrayListTab24h = new ArrayList();
        arrayListTab24h.add(new News("Trang chủ", "https://www.24h.com.vn/upload/rss/trangchu24h.rss"));
        arrayListTab24h.add(new News("Tin tức trong ngày", "https://www.24h.com.vn/upload/rss/tintuctrongngay.rss"));
        arrayListTab24h.add(new News("Bóng đá", "https://www.24h.com.vn/upload/rss/bongda.rss"));
        arrayListTab24h.add(new News("ASIAN CUP 2019", "https://www.24h.com.vn/upload/rss/asiancup2019.rss"));
        arrayListTab24h.add(new News("An ninh - Hình sự", "https://www.24h.com.vn/upload/rss/anninhhinhsu.rss"));
        arrayListTab24h.add(new News("Thời trang", "https://www.24h.com.vn/upload/rss/thoitrang.rss"));
        arrayListTab24h.add(new News("Thời trang Hi-tech", "https://www.24h.com.vn/upload/rss/thoitranghitech.rss"));
        arrayListTab24h.add(new News("Tài chính – Bất động sản", "https://www.24h.com.vn/upload/rss/taichinhbatdongsan.rss"));
        arrayListTab24h.add(new News("Ẩm thực", "https://www.24h.com.vn/upload/rss/amthuc.rss"));
        arrayListTab24h.add(new News("Làm đẹp", "https://www.24h.com.vn/upload/rss/lamdep.rss"));
        arrayListTab24h.add(new News("Phim", "https://www.24h.com.vn/upload/rss/phim.rss"));
        arrayListTab24h.add(new News("Giáo dục - du học", "https://www.24h.com.vn/upload/rss/giaoducduhoc.rss"));
        arrayListTab24h.add(new News("Bạn trẻ - Cuộc sống", "https://www.24h.com.vn/upload/rss/bantrecuocsong.rss"));
        arrayListTab24h.add(new News("Ca nhạc - MTV", "https://www.24h.com.vn/upload/rss/canhacmtv.rss"));
        arrayListTab24h.add(new News("Phi thường - kỳ quặc", "https://www.24h.com.vn/upload/rss/phithuongkyquac.rss"));
        arrayListTab24h.add(new News("Công nghệ thông tin", "https://www.24h.com.vn/upload/rss/congnghethongtin.rss"));
        arrayListTab24h.add(new News("Ô tô", "https://www.24h.com.vn/upload/rss/oto.rss"));
        arrayListTab24h.add(new News("Thị trường - Tiêu dùng", "https://www.24h.com.vn/upload/rss/thitruongtieudung.rss"));
        arrayListTab24h.add(new News("Du lịch", "https://www.24h.com.vn/upload/rss/dulich24h.rss"));
        arrayListTab24h.add(new News("Sức khỏe đời sống", "https://www.24h.com.vn/upload/rss/suckhoedoisong.rss"));
        arrayListTab24h.add(new News("Cười 24h", "https://www.24h.com.vn/upload/rss/cuoi24h.rss"));
        return arrayListTab24h;
    }

    public static ArrayList<News> getDataTabDantri() {
        ArrayList<News> arrayListTabDantri = new ArrayList();
        arrayListTabDantri.add(new News("Trang chủ", "https://dantri.com.vn/trangchu.rss"));
        arrayListTabDantri.add(new News("Sức khỏe", "https://dantri.com.vn/suc-khoe.rss"));
        arrayListTabDantri.add(new News("Xã hội", "https://dantri.com.vn/xa-hoi.rss"));
        arrayListTabDantri.add(new News("Giải trí", "https://dantri.com.vn/giai-tri.rss"));
        arrayListTabDantri.add(new News("Giáo dục-Khuyến học", "https://dantri.com.vn/giao-duc-khuyen-hoc.rss"));
        arrayListTabDantri.add(new News("Thể thao", "https://dantri.com.vn/the-thao.rss"));
        arrayListTabDantri.add(new News("Thế giới", "https://dantri.com.vn/the-gioi.rss"));
        arrayListTabDantri.add(new News("Kinh doanh", "https://dantri.com.vn/kinh-doanh.rss"));
        arrayListTabDantri.add(new News("Ô tô - Xe máy", "https://dantri.com.vn/o-to-xe-may.rss"));
        arrayListTabDantri.add(new News("Sức mạnh số", "https://dantri.com.vn/suc-manh-so.rss"));
        arrayListTabDantri.add(new News("Tình yêu-Giới tính", "https://dantri.com.vn/tinh-yeu-gioi-tinh.rss"));
        arrayListTabDantri.add(new News("Chuyện lạ", "https://dantri.com.vn/chuyen-la.rss"));
        arrayListTabDantri.add(new News("Việc làm", "https://dantri.com.vn/viec-lam.rss"));
        arrayListTabDantri.add(new News("Nhịp sống trẻ", "https://dantri.com.vn/nhip-song-tre.rss"));
        arrayListTabDantri.add(new News("Tấm lòng nhân ái", "https://dantri.com.vn/tam-long-nhan-ai.rss"));
        arrayListTabDantri.add(new News("Pháp luật", "https://dantri.com.vn/phap-luat.rss"));
        arrayListTabDantri.add(new News("Bạn đọc", "https://dantri.com.vn/ban-doc.rss"));
        arrayListTabDantri.add(new News("Diễn đàn", "https://dantri.com.vn/dien-dan.rss"));
        arrayListTabDantri.add(new News("Tuyển sinh", "https://dantri.com.vn/tuyen-sinh.rss"));
        arrayListTabDantri.add(new News("Blog", "https://dantri.com.vn/blog.rss"));
        arrayListTabDantri.add(new News("Văn  hóa", "https://dantri.com.vn/van-hoa.rss"));
        arrayListTabDantri.add(new News("Du lịch", "https://dantri.com.vn/du-lich.rss"));
        arrayListTabDantri.add(new News("Đời sống", "https://dantri.com.vn/doi-song.rss"));
        arrayListTabDantri.add(new News("Khoa học công nghệ", "https://dantri.com.vn/khoa-hoc-cong-nghe.rss"));
        arrayListTabDantri.add(new News("Du học", "https://dantri.com.vn/du-hoc.rss"));
        arrayListTabDantri.add(new News("Bất động sản", "https://dantri.com.vn/bat-dong-san.rss"));
        return arrayListTabDantri;
    }

    public static ArrayList<News> getDataTabThanhnien() {
        ArrayList<News> arrayListTabThanhnien = new ArrayList();
        arrayListTabThanhnien.add(new News("Trang chủ", "https://thanhnien.vn/rss/home.rss"));
        arrayListTabThanhnien.add(new News("Video", "https://video.thanhnien.vn/rss/home.rss"));
        arrayListTabThanhnien.add(new News("Thời sự", "https://thanhnien.vn/rss/viet-nam.rss"));
        arrayListTabThanhnien.add(new News("Thế giới", "https://thanhnien.vn/rss/the-gioi.rss"));
        arrayListTabThanhnien.add(new News("Thể thao", "https://thethao.thanhnien.vn/rss/home.rss"));
        arrayListTabThanhnien.add(new News("Đời sống", "https://thanhnien.vn/rss/doi-song.rss"));
        arrayListTabThanhnien.add(new News("Tài chính-Kinh doanh", "https://thanhnien.vn/rss/kinh-doanh.rss"));
        arrayListTabThanhnien.add(new News("Giới trẻ", "https://thanhnien.vn/rss/the-gioi-tre.rss"));
        arrayListTabThanhnien.add(new News("Giáo dục", "https://thanhnien.vn/rss/giao-duc.rss"));
        arrayListTabThanhnien.add(new News("Công nghệ", "https://thanhnien.vn/rss/cong-nghe-thong-tin.rss"));
        arrayListTabThanhnien.add(new News("Game", "https://game.thanhnien.vn/rss/home.rss"));
        arrayListTabThanhnien.add(new News("Sức khỏe", "https://thanhnien.vn/rss/doi-song/suc-khoe.rss"));
        arrayListTabThanhnien.add(new News("Xe", "https://xe.thanhnien.vn/rss/home.rss"));
        arrayListTabThanhnien.add(new News("Bạn cần biết", "https://thanhnien.vn/rss/ban-can-biet.rss"));
        return arrayListTabThanhnien;
    }

    public static ArrayList<News> getDataTabTuoitre() {
        ArrayList<News> arrayListTabTuoitre = new ArrayList();
        arrayListTabTuoitre.add(new News("Trang chủ", "https://tuoitre.vn/rss/tin-moi-nhat.rss"));
        arrayListTabTuoitre.add(new News("Thế giới", "https://tuoitre.vn/rss/the-gioi.rss"));
        arrayListTabTuoitre.add(new News("Xe", "https://tuoitre.vn/rss/xe.rss"));
        arrayListTabTuoitre.add(new News("Văn hóa", "https://tuoitre.vn/rss/van-hoa.rss"));
        arrayListTabTuoitre.add(new News("Thế thao", "https://tuoitre.vn/rss/the-thao.rss"));
        arrayListTabTuoitre.add(new News("Khoa học", "https://tuoitre.vn/rss/khoa-hoc.rss"));
        arrayListTabTuoitre.add(new News("Giả thật", "https://tuoitre.vn/rss/gia-that.rss"));
        arrayListTabTuoitre.add(new News("Thời sự", "https://tuoitre.vn/rss/thoi-su.rss"));
        arrayListTabTuoitre.add(new News("Pháp luật", "https://tuoitre.vn/rss/phap-luat.rss"));
        arrayListTabTuoitre.add(new News("Công nghệ", "https://tuoitre.vn/rss/nhip-song-so.rss"));
        arrayListTabTuoitre.add(new News("Nhịp sống trẻ", "https://tuoitre.vn/rss/nhip-song-tre.rss"));
        arrayListTabTuoitre.add(new News("Giải trí", "https://tuoitre.vn/rss/giai-tri.rss"));
        arrayListTabTuoitre.add(new News("Giáo dục", "https://tuoitre.vn/rss/giao-duc.rss"));
        arrayListTabTuoitre.add(new News("Sức khỏe", "https://tuoitre.vn/rss/suc-khoe.rss"));
        arrayListTabTuoitre.add(new News("Thư giãn", "https://tuoitre.vn/rss/thu-gian.rss"));
        arrayListTabTuoitre.add(new News("Du lịch", "https://tuoitre.vn/rss/du-lich.rss"));
        return arrayListTabTuoitre;
    }

    public static ArrayList<News> getDataTabNLD() {
        ArrayList<News> arrayListTabNLD = new ArrayList();
        arrayListTabNLD.add(new News("Tin mới nhất", "https://nld.com.vn/tin-moi-nhat.rss"));
        arrayListTabNLD.add(new News("Thời sự trong nước", "https://nld.com.vn/thoi-su.rss"));
        arrayListTabNLD.add(new News("Thời sự quốc tế", "https://nld.com.vn/thoi-su-quoc-te.rss"));
        arrayListTabNLD.add(new News("Tin độc quyền", "https://nld.com.vn/tin-doc-quyen.rss"));
        arrayListTabNLD.add(new News("Kinh tế", "https://nld.com.vn/kinh-te.rss"));
        arrayListTabNLD.add(new News("Giáo dục", "https://nld.com.vn/giao-duc-khoa-hoc.rss"));
        arrayListTabNLD.add(new News("Pháp luật", "https://nld.com.vn/phap-luat.rss"));
        arrayListTabNLD.add(new News("Văn nghệ", "https://nld.com.vn/van-nghe.rss"));
        arrayListTabNLD.add(new News("Thể thao", "https://nld.com.vn/the-thao.rss"));
        arrayListTabNLD.add(new News("Sức khỏe", "https://nld.com.vn/suc-khoe.rss"));
        arrayListTabNLD.add(new News("Công nghệ", "https://nld.com.vn/cong-nghe-thong-tin.rss"));
        arrayListTabNLD.add(new News("Tin mới nhất", "https://nld.com.vn/tin-moi-nhat.rss"));
        arrayListTabNLD.add(new News("Địa phương", "https://nld.com.vn/dia-phuong.rss"));
        return arrayListTabNLD;
    }

    public static ArrayList<News> getDataTabSoha() {
        ArrayList<News> arrayListTabSoha = new ArrayList();
        arrayListTabSoha.add(new News("Giải trí", "http://soha.vn/giai-tri.rss"));
        arrayListTabSoha.add(new News("Thể thao", "http://soha.vn/the-thao.rss"));
        arrayListTabSoha.add(new News("Thời sự", "http://soha.vn/thoi-su.rss"));
        arrayListTabSoha.add(new News("Pháp luật", "http://soha.vn/phap-luat.rss"));
        arrayListTabSoha.add(new News("Kinh doanh", "http://soha.vn/kinh-doanh.rss"));
        arrayListTabSoha.add(new News("Quốc tế", "http://soha.vn/quoc-te.rss"));
        arrayListTabSoha.add(new News("Sống khỏe", "http://soha.vn/song-khoe.rss"));
        arrayListTabSoha.add(new News("Quân sự", "http://soha.vn/quan-su.rss"));
        arrayListTabSoha.add(new News("Cư dân mạng", "http://soha.vn/cu-dan-mang.rss"));
        arrayListTabSoha.add(new News("Khám phá", "http://soha.vn/kham-pha.rss"));
        arrayListTabSoha.add(new News("InfoGraphic", "http://soha.vn/infographic.rss"));
        arrayListTabSoha.add(new News("Đời sống", "http://soha.vn/doi-song.rss"));
        return arrayListTabSoha;
    }

    public static ArrayList<News> getDataTabNDT() {
        ArrayList<News> arrayListTabNDT = new ArrayList();
        arrayListTabNDT.add(new News("Trang chủ", "https://www.nguoiduatin.vn/trang-chu.rss"));
        arrayListTabNDT.add(new News("Pháp luật", "https://www.nguoiduatin.vn/rss/phap-luat.rss"));
        arrayListTabNDT.add(new News("Nhịp sống", "https://www.nguoiduatin.vn/rss/nhip-song.rss"));
        arrayListTabNDT.add(new News("Kinh doanh", "https://www.nguoiduatin.vn/rss/kinh-doanh.rss"));
        arrayListTabNDT.add(new News("Thế giới", "https://www.nguoiduatin.vn/rss/the-gioi.rss"));
        arrayListTabNDT.add(new News("Người trẻ", "https://www.nguoiduatin.vn/rss/nguoi-tre.rss"));
        arrayListTabNDT.add(new News("Địa phương", "https://www.nguoiduatin.vn/rss/dia-phuong.rss"));
        arrayListTabNDT.add(new News("Cần biết", "https://www.nguoiduatin.vn/rss/can-biet.rss"));
        arrayListTabNDT.add(new News("Xã  hội", "https://www.nguoiduatin.vn/rss/chinh-tri-xa-hoi.rss"));
        arrayListTabNDT.add(new News("Giải trí", "https://www.nguoiduatin.vn/rss/giai-tri.rss"));
        arrayListTabNDT.add(new News("Đời sống", "https://www.nguoiduatin.vn/rss/doi-song.rss"));
        arrayListTabNDT.add(new News("Nghe xem", "https://www.nguoiduatin.vn/rss/nghe-xem.rss"));
        arrayListTabNDT.add(new News("Video", "https://www.nguoiduatin.vn/rss/video.rss"));
        arrayListTabNDT.add(new News("Công nghệ", "https://www.nguoiduatin.vn/rss/cong-nghe.rss"));
        return arrayListTabNDT;
    }

    public static ArrayList<News> getDataTabDSPL() {
        ArrayList<News> arrayListDSPL = new ArrayList();
        arrayListDSPL.add(new News("Trang chủ", "http://www.doisongphapluat.com/trang-chu.rss"));
        arrayListDSPL.add(new News("Tin tức", "http://www.doisongphapluat.com/rss/tin-tuc.rss"));
        arrayListDSPL.add(new News("Thể thao", "http://www.doisongphapluat.com/rss/the-thao.rss"));
        arrayListDSPL.add(new News("Cần biết", "http://www.doisongphapluat.com/rss/can-biet.rss"));
        arrayListDSPL.add(new News("Ôtô-Xe máy", "http://www.doisongphapluat.com/rss/oto-xemay.rss"));
        arrayListDSPL.add(new News("Địa phương", "http://www.doisongphapluat.com/rss/dia-phuong.rss"));
        arrayListDSPL.add(new News("Đời sống", "http://www.doisongphapluat.com/rss/doi-song.rss"));
        arrayListDSPL.add(new News("Video", "http://www.doisongphapluat.com/rss/video.rss"));
        arrayListDSPL.add(new News("Đánh giá sản phẩm", "http://www.doisongphapluat.com/rss/danh-gia-san-pham.rss"));
        return arrayListDSPL;
    }

    public static ArrayList<News> getDataTabVTCNew() {
        ArrayList<News> arrayListVTC = new ArrayList();
        arrayListVTC.add(new News("Trang chủ", "https://vtc.vn/feed.rss"));
        arrayListVTC.add(new News("Xã hội", "https://vtc.vn/xa-hoi.rss"));
        arrayListVTC.add(new News("Kinh tế", "https://vtc.vn/kinh-te.rss"));
        arrayListVTC.add(new News("Truyền hình", "https://vtc.vn/truyenhinh.rss"));
        arrayListVTC.add(new News("Pháp luật", "https://vtc.vn/phap-luat.rss"));
        arrayListVTC.add(new News("Quốc tế", "https://vtc.vn/quoc-te.rss"));
        arrayListVTC.add(new News("Giải trí", "https://vtc.vn/giai-tri.rss"));
        arrayListVTC.add(new News("Thể thao", "https://vtc.vn/the-thao.rss"));
        arrayListVTC.add(new News("Giới trẻ", "https://vtc.vn/gioi-tre.rss"));
        arrayListVTC.add(new News("Giáo dục", "https://vtc.vn/giao-duc.rss"));
        arrayListVTC.add(new News("Công nghệ", "https://vtc.vn/cong-nghe.rss"));
        arrayListVTC.add(new News("Khỏe và đẹp", "https://vtc.vn/khoe-va-dep.rss"));
        return arrayListVTC;
    }

    public static ArrayList<News> getDataTabVOV() {
        ArrayList<News> arrayListVOV = new ArrayList();
        arrayListVOV.add(new News("Chính trị", "https://vov.vn/rss/chinh-tri-209.rss"));
        arrayListVOV.add(new News("Đời sống", "https://vov.vn/rss/doi-song-218.rss"));
        arrayListVOV.add(new News("Doanh nghiệp", "https://vov.vn/rss/kinh-te/doanh-nghiep-277.rss"));
        arrayListVOV.add(new News("Xã hội", "https://vov.vn/rss/xa-hoi-314.rss"));
        arrayListVOV.add(new News("Kinh tế", "https://vov.vn/rss/kinh-te-212.rss"));
        arrayListVOV.add(new News("Thế giới", "https://vov.vn/rss/the-gioi-213.rss"));
        arrayListVOV.add(new News("Pháp luật", "https://vov.vn/rss/phap-luat-237.rss"));
        arrayListVOV.add(new News("Quân sự-Quốc phòng", "https://vov.vn/rss/quan-su-quoc-phong-445.rss"));
        arrayListVOV.add(new News("Công nghệ", "https://vov.vn/rss/cong-nghe-449.rss"));
        arrayListVOV.add(new News("Thể thao", "https://vov.vn/rss/the-thao-214.rss"));
        arrayListVOV.add(new News("Văn hóa", "https://vov.vn/rss/van-hoa-giai-tri-215.rss"));
        arrayListVOV.add(new News("Người việt", "https://vov.vn/rss/nguoi-viet-287.rss"));
        arrayListVOV.add(new News("Sức khỏe", "https://vov.vn/rss/suc-khoe-311.rss"));
        arrayListVOV.add(new News("Ôtô-Xe máy", "https://vov.vn/rss/oto-xe-may-423.rss"));
        return arrayListVOV;
    }

    public static ArrayList<News> getDataTabTT247() {
        ArrayList<News> arrayListTT247 = new ArrayList();
        arrayListTT247.add(new News("Trang chủ", "https://thethao247.vn/trang-chu.rss"));
        arrayListTT247.add(new News("Bóng đá VN", "https://thethao247.vn/bong-da-viet-nam-c1.rss"));
        arrayListTT247.add(new News("Bóng đá QT", "https://thethao247.vn/bong-da-quoc-te-c2.rss"));
        arrayListTT247.add(new News("Thể thao", "https://thethao247.vn/the-thao-tong-hop-c5.rss"));
        arrayListTT247.add(new News("Video", "https://thethao247.vn/video-c6.rss"));
        arrayListTT247.add(new News("Esports", "https://thethao247.vn/esports-c180.rss"));
        arrayListTT247.add(new News("Bóng đá 247", "https://thethao247.vn/bongda247-c157.rss"));
        arrayListTT247.add(new News("Chuyển nhượng", "https://thethao247.vn/tin-chuyen-nhuong-c14.rss"));
        return arrayListTT247;
    }

    public static ArrayList<News> getDataTabITCNews() {
        ArrayList<News> arrayListITVNews = new ArrayList();
        arrayListITVNews.add(new News("Thời sự","https://ictnews.vn/rss/thoi-su"));
        arrayListITVNews.add(new News("Cải cách hành chính","https://ictnews.vn/rss/vien-thong/cai-cach-hanh-chinh"));
        arrayListITVNews.add(new News("Internet","https://ictnews.vn/rss/internet"));
        arrayListITVNews.add(new News("Phần mềm","https://ictnews.vn/rss/cntt/phan-mem"));
        arrayListITVNews.add(new News("Kinh doanh","https://ictnews.vn/rss/kinh-doanh"));
        arrayListITVNews.add(new News("Thị trường","https://ictnews.vn/rss/kinh-doanh/thi-truong"));
        arrayListITVNews.add(new News("Máy ảnh số","https://ictnews.vn/rss/the-gioi-so/may-anh-so"));
        arrayListITVNews.add(new News("Công nghệ 360","https://ictnews.vn/rss/cong-nghe-360"));
        arrayListITVNews.add(new News("Viễn thông","https://ictnews.vn/rss/vien-thong"));
        arrayListITVNews.add(new News("CNTT","https://ictnews.vn/rss/cntt"));
        arrayListITVNews.add(new News("Phần cứng","https://ictnews.vn/rss/cntt/phan-cung"));
        arrayListITVNews.add(new News("Thế giới số","https://ictnews.vn/rss/the-gioi-so"));
        arrayListITVNews.add(new News("Di động","https://ictnews.vn/rss/the-gioi-so/di-dong"));
        arrayListITVNews.add(new News("Khởi nghiệp","https://ictnews.vn/rss/khoi-nghiep"));
        return arrayListITVNews;
    }

    public static ArrayList<News> getDataTabNgoisao() {
        ArrayList<News> arrayListNgoisao = new ArrayList();
        arrayListNgoisao.add(new News("Hậu trường","https://ngoisao.net/rss/hau-truong.rss"));
        arrayListNgoisao.add(new News("Thời cuộc","https://ngoisao.net/rss/thoi-cuoc.rss"));
        arrayListNgoisao.add(new News("Thư giãn","https://ngoisao.net/rss/thu-gian.rss"));
        arrayListNgoisao.add(new News("Showbiz-việt","https://ngoisao.net/rss/showbiz-viet.rss"));
        arrayListNgoisao.add(new News("Âu mỹ","https://ngoisao.net/rss/au-my.rss"));
        arrayListNgoisao.add(new News("Châu Á","https://ngoisao.net/rss/chau-a.rss"));
        arrayListNgoisao.add(new News("Thời trang","https://ngoisao.net/rss/thoi-trang.rss"));
        arrayListNgoisao.add(new News("Dân chơi","https://ngoisao.net/rss/dan-choi.rss"));
        arrayListNgoisao.add(new News("Thi ảnh","https://ngoisao.net/rss/thi-anh.rss"));
        arrayListNgoisao.add(new News("Ảnh cưới","https://ngoisao.net/rss/anh-cuoi.rss"));
        return  arrayListNgoisao;
    }
}
