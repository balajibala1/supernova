package demo.controller;

import demo.model.Demo;
import demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @PostMapping("/save")
    public String save(@RequestBody Demo demos) throws ExecutionException, InterruptedException {
        return demoService.save(demos);
    }
    @GetMapping("/view")
    public List<Demo> view() throws ExecutionException, InterruptedException {
        return  demoService.getDetails();
    }
    @PutMapping("/edit/{name}")
    public String update(@RequestBody Demo demos,@PathVariable String name) throws ExecutionException, InterruptedException {
        return demoService.update(demos);
    }
    @DeleteMapping("/delete/{name}")
    public String delete(@PathVariable String name) throws ExecutionException, InterruptedException {
        return demoService.delete(name);
    }

}