package com.booking;

import com.booking.payload.request.RoomRequest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

import java.util.List;
@SpringBootApplication
@EnableJpaAuditing
public class HotelBookingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingApiApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//        FileReader file = new FileReader("C:\\Users\\Admin\\Desktop\\CDWEB_\\cdw_booking\\src\\main\\java\\com\\booking\\data\\rooms.json");
//        JSONParser jsonParser = new JSONParser(file);
//        ArrayList<Object> requests = jsonParser.parseArray();
////           for(Object o:requests){
////               ObjectMapper objectMapper =new ObjectMapper();
////               RoomRequest request =objectMapper.convertValue(o,RoomRequest.class);
////               RoomRequest request =o;
//            Gson gson =new Gson();
//            RoomRequest request =gson.fromJson(,RoomRequest.class);
//            System.out.println(requests.get(0).toString().getBytes());
////           }
//    };
//}
//    @Bean
//    CommandLineRunner commandLineRunner(
//            ProvinceService provinceService,
//            DistrictService districtService,
//            WardService wardService,
//            CategoryService categoryService,
//            RoleService roleService) {
//        return args -> {
//            saveProvince(provinceService);
//            saveDistrict(provinceService,districtService);
//            saveWard(districtService,wardService);
//            RoleRequest roleRequest;
//
//
//            CategoryRequest categoryRequest = CategoryRequest.builder()
//                    .name("Home Stay")
//                    .code("home-stay")
//                    .build();
//            CategoryRequest categoryRequest1 = CategoryRequest.builder()
//                    .name("Villa")
//                    .code("villa")
//                    .build();
//            CategoryRequest categoryRequest2 = CategoryRequest.builder()
//                    .name("Resort")
//                    .code("resort")
//                    .build();
//            CategoryRequest categoryRequest3 = CategoryRequest.builder()
//                    .name("Hotel")
//                    .code("hotel")
//                    .build();
//            categoryService.save(categoryRequest1);
//            categoryService.save(categoryRequest2);
//            categoryService.save(categoryRequest3);
//            categoryService.save(categoryRequest);
//
//        };
//    }
//
//    public static void saveProvince(ProvinceService provinceService){
//        try {
//            FileReader file = new FileReader("C:\\Users\\Admin\\Desktop\\CDWEB_\\cdw_booking\\src\\main\\java\\com\\booking\\data\\province.json");
//            JSONParser jsonParser = new JSONParser(file);
//            LinkedHashMap<String, Object> os = jsonParser.parseObject();
//            for (String s : os.keySet()) {
//                String provinceString = os.get(s).toString().replaceAll("[{}]", "");
//                String[] arr = provinceString.split("[,=]");
//                ProvinceRequest request = ProvinceRequest.builder()
//                        .name(arr[1])
//                        .slug(arr[5])
//                        .type(arr[3])
//                        .nameWithType(arr[7])
//                        .code(arr[9])
//                        .build();
//    provinceService.save(request);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    public static void saveDistrict(ProvinceService provinceService,DistrictService districtService){
//        try {
//            FileReader file = new FileReader("C:\\Users\\Admin\\Desktop\\CDWEB_\\cdw_booking\\src\\main\\java\\com\\booking\\data\\district.json");
//            JSONParser jsonParser = new JSONParser(file);
//            LinkedHashMap<String, Object> os = jsonParser.parseObject();
//            for (String s : os.keySet()) {
//                String provinceString = os.get(s).toString().replaceAll("[{}]", "");
//                String[] arr = provinceString.split("[,=]");
//                ProvinceEntity province = provinceService.getByCode(arr[17]);
//                DistrictRequest request = DistrictRequest.builder()
//                        .name(arr[1])
//                        .slug(arr[5])
//                        .type(arr[3])
//                        .nameWithType(arr[7])
//                        .path(arr[9]+", "+arr[10])
//                        .pathWithType(arr[12]+", "+arr[13])
//                        .code(arr[15])
//                        .parentCode(arr[17])
//                        .provinceId(province.getId())
//                        .build();
//
//                districtService.save(request);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    public static   void saveWard(DistrictService districtService,WardService wardService){
//        try {
//            FileReader file = new FileReader("C:\\Users\\Admin\\Desktop\\CDWEB_\\cdw_booking\\src\\main\\java\\com\\booking\\data\\ward.json");
//            JSONParser jsonParser = new JSONParser(file);
//            LinkedHashMap<String, Object> os = jsonParser.parseObject();
//            for (String s : os.keySet()) {
//                String provinceString = os.get(s).toString().replaceAll("[{}]", "");
//                String[] arr = provinceString.split("[,=]");
//                DistrictEntity districtEntity =districtService.getByCode(arr[19]);
//                WardRequest request = WardRequest.builder()
//                        .name(arr[1])
//                        .slug(arr[5])
//                        .type(arr[3])
//                        .nameWithType(arr[7])
//                        .path(arr[9]+", "+arr[10]+", "+arr[11])
//                        .pathWithType(arr[13]+", "+arr[14]+", "+arr[15])
//                        .code(arr[17])
//                        .parentCode(arr[19])
//                        .districtId(districtEntity.getId())
//                        .build();
//                wardService.save(request);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
