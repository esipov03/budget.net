package com.hakaton.budshet.convertor;

import com.hakaton.budshet.entity.Process;
import com.hakaton.budshet.model.response.AdminProcessResponse;
import org.apache.tomcat.jni.Proc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminProcessConverter {

      public List<AdminProcessResponse> processConverter(List<Process> processes){
          List<AdminProcessResponse> response = new ArrayList<>();
          processes.forEach(p->{
              AdminProcessResponse processResponse = new AdminProcessResponse(p);
              response.add(processResponse);

          });

          return response;
      }
}
