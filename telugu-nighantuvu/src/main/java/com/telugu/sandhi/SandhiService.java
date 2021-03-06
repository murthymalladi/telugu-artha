package com.telugu.sandhi;

import com.telugu.nighantuvu.Nighantuvu;
import com.telugu.models.SandhiResponse;
import com.telugu.sandhi.sanskrit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinaykk on 22/01/17.
 */
public class SandhiService {
    private Nighantuvu nighantuvu;
    private List<BasicSandhi> sandhiList = new ArrayList<BasicSandhi>();

    public SandhiService() {
        this.nighantuvu = new Nighantuvu();
        sandhiList.add(new SavarnaDheergaSandhi());
        sandhiList.add(new GuNaSandhi());
        sandhiList.add(new AnunasikaSandhi());
        sandhiList.add(new VRddiSandhi());
        sandhiList.add(new YanaDesaSandhi());
        sandhiList.add(new ParasavarnaSandhi());
        sandhiList.add(new SchutvaSandhi());
        sandhiList.add(new VisargaSandhi());
    }

    public SandhiService(Nighantuvu nighantuvu) {
        this.nighantuvu = nighantuvu;
        sandhiList.add(new SavarnaDheergaSandhi());
        sandhiList.add(new GuNaSandhi());
        sandhiList.add(new AnunasikaSandhi());
        sandhiList.add(new VRddiSandhi());
        sandhiList.add(new YanaDesaSandhi());
        sandhiList.add(new ParasavarnaSandhi());
        sandhiList.add(new SchutvaSandhi());
        sandhiList.add(new VisargaSandhi());
    }

    public SandhiResponse isSandhi(String token, boolean isTeluguScript) {
        for(BasicSandhi sandhi: sandhiList) {
                SandhiResponse response = sandhi.isSandhi(token, nighantuvu, isTeluguScript);
                if(response.isSandhi()){
                    return response;
                }
        }
        return new SandhiResponse(false);
    }
}
