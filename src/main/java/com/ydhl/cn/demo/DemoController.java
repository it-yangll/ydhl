package com.ydhl.cn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @ClassName DemoController
 * @Description TODO
 * @Author yangll
 * @Date 2019/9/3 0003 13:29
 * @Version 1.0
 **/
@RestController
public class DemoController {

    @Value("${girl.cupSize}")
    private String cupSize;

    @Value("${girl.name}")
    private String name;

    @Value("${girl.age}")
    private String age;

    @Value("${content}")
    private String content;

    @Autowired
    private Girl girl;

    @Autowired
    private BoyRepository boyRepository;

    /**
     * 单查
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public Optional<Boy> findById(@PathVariable(value = "id")Integer id){
        return boyRepository.findById(id);
    }

    /**
     * 全查
     * @return
     */
    @GetMapping(value = "/findAll")
    public List<Boy> findAll(){
        List<Boy> boyList = boyRepository.findAll();
        List<Boy> boys = new ArrayList<>();
        boyList.forEach(boy ->{
            switch (boy.getSex()){
                case "0":
                    boy.setSex("男");
                    break;
                case "1":
                    boy.setSex("女");
                    break;
            }
            boys.add(boy);

        });

        return boys;
    }

    /**
     * 保存
     * @param boy
     * @return
     */
    @PostMapping("/save")
    @Transactional
    public Boy adBoy(@RequestBody Boy boy){
        return boyRepository.save(boy);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    @Transactional
    public String delete(@PathVariable(value = "id")Integer id){
        boyRepository.deleteById(id);
        return "success";
    }

    /**
     * 修改
     * @param boy
     * @return
     */
    @PutMapping("/modify/{id}")
    @Transactional
    public Boy modify(@RequestBody Boy boy){
        return  boyRepository.save(boy);
    }

    /**
     * 名称查询
     * @param name
     * @return
     */
    @GetMapping("/findByName")
    public List<Boy> findByName(@RequestParam("name")String name){
        return boyRepository.findByName(name);
    }


    /**
     * 从配置文件获取数据
     * application.yml
     * @param id
     * @return
     */
    @GetMapping(value = {"/hello","/hi/{id}"})
    public String say(@PathVariable(value = "id",required = false) Integer id){
        return "spring Boot :"+cupSize+" so easy:"+name+" Demo一小步:"+name+" 的一大步。\n"+age+(id!=null?" id:"+id:"");
    }

    /**
     * 从配置文件获取数据
     * application.yml
     * @param id
     * @return
     */
    @GetMapping("/girl")
    public String girl(@RequestParam(value = "id",required = false,defaultValue = "18")Integer id){
        girl.setAge(id);
        return "亲爱的: "+girl.getName()+" 同学，虽然你仅有: "+girl.getAge()+" 但是你的罩杯却有:"+girl.getCupSize()+" \n年少有为不自卑. \r\n "+content;
    }







}
