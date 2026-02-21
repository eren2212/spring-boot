package com.ereniridere.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ereniridere.dto.DtoHome;
import com.ereniridere.dto.DtoRoom;
import com.ereniridere.entites.Home;
import com.ereniridere.entites.Room;
import com.ereniridere.repository.HomeRepository;
import com.ereniridere.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private HomeRepository homeRepository;

	@Override
	public DtoHome findHomeById(Long id) {

		Optional<Home> optional = homeRepository.findById(id);

		if (optional.isEmpty()) {
			return null;
		}

		Home dbHome = optional.get();
		List<Room> dbRooms = optional.get().getRoom();

		DtoHome dtoHome = new DtoHome();
		BeanUtils.copyProperties(dbHome, dtoHome);

		if (dbRooms != null && !dbRooms.isEmpty()) {
			for (Room room : dbRooms) {
				DtoRoom dtoRoom = new DtoRoom();
				BeanUtils.copyProperties(room, dtoRoom);

				dtoHome.getRooms().add(dtoRoom);
			}

		}

		return dtoHome;
	}

}
