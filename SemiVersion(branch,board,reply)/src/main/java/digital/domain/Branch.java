package digital.domain;

import java.util.List;

public class Branch {
	int no;
	String name;
	String addr;
	String tel;
	String image;
	String intro;
	String area;
	String lilg;
	String date;
	int bmno;
	String bmname;
	List<String> photoList;

	@Override
	public String toString() {
		return "Branch [no=" + no + ", name=" + name + ", addr=" + addr + ", tel=" + tel + ", image=" + image
				+ ", intro=" + intro + ", area=" + area + ", lilg=" + lilg + ", bmno=" + bmno + ", bmname=" + bmname
				+ ", photoList=" + photoList + "]";
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public List<String> getPhotoList() {
		return photoList;
	}
	public void setPhotoList(List<String> photoList) {
		this.photoList = photoList;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLilg() {
		return lilg;
	}
	public void setLilg(String lilg) {
		this.lilg = lilg;
	}
	public int getBmno() {
		return bmno;
	}
	public void setBmno(int bmno) {
		this.bmno = bmno;
	}
	public String getBmname() {
		return bmname;
	}
	public void setBmname(String bmname) {
		this.bmname = bmname;
	}
	
}
