package domain;

import java.util.ArrayList;
import java.util.List;

import db.MessageRepository;
import db.MessageRepositoryStub;
import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {

	private PersonRepository personRepository = new PersonRepositoryStub();
	private MessageRepository messageRepository = new MessageRepositoryStub();

	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}



	public boolean sendMessage(String from, String to, String msg) {
		return messageRepository.sendMessage(from, to, msg);
	}

	public ArrayList<String[]> getMessagesBetween(String from, String to) {
		return messageRepository.getMessagesFrom(from, to);
	}

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}
}
