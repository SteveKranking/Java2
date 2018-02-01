package com.project.LOTBeltReview.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.LOTBeltReview.models.Guild;
import com.project.LOTBeltReview.models.User;

import com.project.LOTBeltReview.repositories.GuildRepository;

@Service
public class GuildService {
	// Member variables / service initializations go here
	private GuildRepository _gr;

	public GuildService(GuildRepository _gr){
		this._gr = _gr;
	}

	public void createGuild(Guild guild, String name, int numMembers)  {
		
		guild.setGuildName(name);
		guild.setGuildSize(numMembers);

		_gr.save(guild);
	}
	
	public Guild findOne(Long id) {
		return (Guild) _gr.findOne(id);
	}

	public List<Guild> getAllGuilds() {
		return (List<Guild>) _gr.findAll();
	}

	public void destroy(Long id) {
		Guild guild = _gr.findOne(id);
		_gr.delete(guild);
	}

	public void addAttendee(Long id, User user) {
		Guild guild = _gr.findOne(id);
		List<User> members = guild.getMembers();
		members.add(user);
		guild.setMembers(members);
		_gr.save(guild);
	}

	public void removeMember(Long id, User user) {
		Guild guild = _gr.findOne(id);
		List<User> members = guild.getMembers();
		members.remove(user);
		guild.setMembers(members);
		_gr.save(guild);
	}

	public void updateEvent(Guild guild, User user, String name) {
		
		guild.setGuildName(name);
		guild.setMembers((List<User>) user);
		_gr.save(guild);
	}
	// Crud methods to act on services go here.
}
