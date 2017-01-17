package site.jjilikeyou.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.jjilikeyou.www.dao.DataMapper;
import site.jjilikeyou.www.model.Message;
import site.jjilikeyou.www.service.DataService;
@Service
public class DataServiceImple implements DataService {
	@Autowired
	private DataMapper dataMapper;
	@Override
	public void sendMsg(Message message) {
		
		 dataMapper.sendMsg(message);
	}

}
