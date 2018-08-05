package ${classPackage}.controller;

import static org.springframework.http.HttpStatus.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import ${classPackage}.util.ApplicationSettings;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/template/v1", produces=MediaType.APPLICATION_JSON_VALUE)
@Api(value = "template", description = "Starter Template API")
public class ${className} {

	@Autowired
	ApplicationSettings applicationSettings;

    @ApiOperation(value = "Returns 'test message'",response = String.class)
	@RequestMapping(method=RequestMethod.GET,value="/test", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("{\"This\":\"is a test..\"}", OK);
	}
}