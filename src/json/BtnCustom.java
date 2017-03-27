package json;

import java.util.ArrayList;
import java.util.List;

public class BtnCustom {

	@Override
	public String toString() {
		return "BtnCustom [bList=" + bList + "]";
	}

	private List<Btn> bList;

	public List<Btn> getbList() {
		return bList;
	}

	public void setbList(List<Btn> bList) {
		this.bList = bList;
	}
	
	public List<Long> getBtnIds(){
		List<Long> list = new ArrayList<Long>();
		List<Btn> btnList = getbList();
		for(Btn b : btnList){
			list.add(b.getId());
		}
		return list;
	}
	
}
