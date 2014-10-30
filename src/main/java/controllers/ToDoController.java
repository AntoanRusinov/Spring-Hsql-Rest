package controllers;

import java.sql.Timestamp;
import model.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.ToDoService;

/**
 * @author antoan
 *
 *         ToDoController that use ToDoService to access necessary methods.
 *         Serves for REST
 */
@Controller
@RequestMapping("/todo")
public class ToDoController {

	public ToDoService toDoService;

	// just for test
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	@ResponseBody
	public String showIndex() {
		return "Ping Succeeded!";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ToDo findById(@RequestParam(value="id", defaultValue="1") int id) {
		return toDoService.findById(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createToDo(@RequestParam int id, String content) {
		toDoService.createToDo(id, content);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> updateToDo(@RequestParam ToDo toDo,@RequestParam int id, String content) {
		toDo.setTo_do_id(id);
		toDo.setContent(content);
		toDo.setLastModifiedDate(new Timestamp(System.currentTimeMillis()));
		toDoService.update(toDo);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> deleteToDo(@RequestParam int id) {
		toDoService.delete(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> saveToDo(@RequestParam ToDo toDo) {
		toDoService.save(toDo);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public ToDo listAll() {
		return this.toDoService.listAll();
	}

}
