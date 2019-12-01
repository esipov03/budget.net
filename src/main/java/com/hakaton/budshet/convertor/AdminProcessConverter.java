package com.hakaton.budshet.convertor;

import com.hakaton.budshet.entity.Process;
import com.hakaton.budshet.model.response.ProcessResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminProcessConverter {

      public List<ProcessResponse> processConverter(List<Process> processes){
          List<ProcessResponse> response = new ArrayList<>();
          processes.forEach(p->{
              ProcessResponse processResponse = new ProcessResponse(p);
              response.add(processResponse);

          });

          return response;
      }
}
