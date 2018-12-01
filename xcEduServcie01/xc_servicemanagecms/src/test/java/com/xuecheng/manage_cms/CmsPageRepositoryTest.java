package com.xuecheng.manage_cms;


import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Optional;


@SpringBootTest
@RunWith(SpringRunner.class)

public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;



    @Test
    public void testFindPage(){
        int page=0;
        int size=10;
        Pageable of = PageRequest.of(page, size);

        Page<CmsPage> all=cmsPageRepository.findAll(of);

        System.out.println(all.getContent());
    }
    @Test
    public void listTest(){


        List<CmsPage> all=cmsPageRepository.findAll();

        System.out.println(all);
    }


      @Test
       public void testUpdate(){

        Optional<CmsPage> optional = cmsPageRepository.findById("5af942190e661827d8e2f5e3");
          if(optional.isPresent()){
              CmsPage cmsPage = optional.get();
              cmsPage.setPageName("测试页面01");
              cmsPageRepository.save(cmsPage);
          }



      }


    @Test
    public void testDelete() {
        cmsPageRepository.deleteById("5b17a2c511fe5e0c409e5eb3");
    }

    @Test
      public void findName(){
        CmsPage byPageName = cmsPageRepository.findByPageName("preview_4028e58161bd3b380161bd3bcd2f0000.html");

        System.out.println(byPageName);


    }




}
