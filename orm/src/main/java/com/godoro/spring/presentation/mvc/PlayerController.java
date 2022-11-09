package com.godoro.spring.presentation.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.spring.configuration.MyBean;
import com.godoro.spring.data.entity.Player;
import com.godoro.spring.data.repository.PlayerRepository;

@Controller
@RequestMapping("/sports")
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private MyBean myBean;

	@GetMapping("/players/byteam")
	@ResponseBody
	public String getPlayersByTeam(){
		System.out.println("Çekirdek " + myBean.getMyLong() + " "
				+ myBean.getMyString() + " "
				+ myBean.getMyDouble());
		long teamId = 1;
		List<Player> players = playerRepository.findAllByTeamId(teamId);
		double totalScore = 0;
		for(Player player : players) {
			System.out.println(player.getPlayerId() + " "
					+ player.getPlayerName() + " "
					+ player.getAvarageScore());
			totalScore += player.getAvarageScore();
		}
		double avarageScore = 0;
		if(players.size() > 0) {
			avarageScore = totalScore / players.size();
		}
		return "Ortalama Çentik: " + avarageScore;
	}
}
