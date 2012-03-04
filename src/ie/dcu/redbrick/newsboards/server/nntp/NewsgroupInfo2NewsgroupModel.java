package ie.dcu.redbrick.newsboards.server.nntp;

import org.apache.commons.net.nntp.NewsgroupInfo;

import com.google.common.base.Function;

import ie.dcu.redbrick.newsboards.shared.nntp.NewsgroupModel;

public class NewsgroupInfo2NewsgroupModel implements Function<NewsgroupInfo, NewsgroupModel> {

    public NewsgroupModel apply(NewsgroupInfo input) {
        NewsgroupModel model = new NewsgroupModel();
        
        model.setName(input.getNewsgroup());
        model.setArticleCount(input.getArticleCountLong());
        
        return model;
    }
}
