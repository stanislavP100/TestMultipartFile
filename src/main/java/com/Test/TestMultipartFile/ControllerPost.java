package com.Test.TestMultipartFile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerPost {

    private final StorageService storageService;
    @Autowired
    public ControllerPost(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    private RepositoryGoods repositoryGoods;

    @Autowired
    private RepositoryElektroTools repositoryElektroTools;

    @GetMapping("/pos")
    public   String methodGetForPost(Model model) throws Exception {
//
//        model.addAttribute("files", storageService.loadAll().map(
//                path -> MvcUriComponentsBuilder.fromMethodName(ControllerPost.class,
//                        "serveFile", path.getFileName().toString()).build().toUri().toString())
//                .collect(Collectors.toList()));

        return "index";
    }

    @PostMapping("/post")

    public String methodPost(@RequestParam MultipartFile file,
                             RedirectAttributes redirectAttributes){

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");


        System.out.println("PPPPPPPPPPPPPPP");

//
//        if(category.equals("goods")) {
//    Goods goods = new Goods();
//
//    goods.setName(name);
//
//    goods.setPrice(price);
//
//    repositoryGoods.save(goods);
//}
//
//        if(category.equals("electroTools")) {
//            ElectroTools electroTools = new ElectroTools();
//
//            electroTools.setName(name);
//
//            electroTools.setPrice(price);
//
//            electroTools.setFilePath(file.getOriginalFilename());
//
//            repositoryElektroTools.save(electroTools);
//        }
        return "index";
    }
}
