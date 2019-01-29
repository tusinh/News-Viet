package vn.com.newsviet.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import vn.com.newsviet.MainActivity;
import vn.com.newsviet.R;
import vn.com.newsviet.Utils.MyLog;
import vn.com.newsviet.Utils.ShowPopup;
import vn.com.newsviet.Utils.Utils;
import vn.com.newsviet.adapter.ListNewsAdapter;
import vn.com.newsviet.model.News;

/*create by tusinh on 1/2019*/
public class FragmentListNews extends Fragment {
    ListNewsAdapter adapter;
    ArrayList<News> data = new ArrayList();
    RecyclerView recyclerview;
    LinearLayout layout_loading;
    String link = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_new, container, false);
        Anhxa(view);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ListNewsAdapter(getContext(), data);
        recyclerview.setAdapter(adapter);
        Bundle bundle = this.getArguments();
        if (bundle != null && bundle.containsKey("link")) {
            link = bundle.getString("link");
            MyLog.Log("FragmentListNews->link: " + link);
        }
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
        if (!Utils.isNetworkConnected(getActivity())) {
            new ShowPopup(getActivity()).info(getString(R.string.no_internet), getString(R.string.title_notify)).show();
        } else {
            if (!link.isEmpty()) new Readdata().execute(link);
        }

//            }
//        });
        return view;
    }

    private void MyOnLoading() {
        layout_loading.setVisibility(View.VISIBLE);
        recyclerview.setVisibility(View.GONE);
    }

    private void MyOnShowData() {
        layout_loading.setVisibility(View.GONE);
        recyclerview.setVisibility(View.VISIBLE);
    }

    private void Anhxa(View view) {
        recyclerview = view.findViewById(R.id.recyclerview);
        layout_loading = view.findViewById(R.id.layout_loading);
    }

    class Readdata extends AsyncTask<String, Void, ArrayList<News>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MyOnLoading();
        }

        @Override
        protected ArrayList<News> doInBackground(String... params) {
//            return Utils.docNoiDung_Tu_URL(params[0]);
            try {
                Document document = Jsoup.connect(params[0]).get();
//                Document document = Jsoup.parse(s);
                Elements item_eles = document.getElementsByTag("item");
                String title = "";
                String link = "";
                String img = "";
                String guid = "";
                String description_short = "";
                String pubDate = "";
                for (Element item_ele : item_eles) {

                    Element title_ele = item_ele.getElementsByTag("title").first();
                    Element link_ele = item_ele.getElementsByTag("link").first();
                    Element guid_ele = item_ele.getElementsByTag("guid").first();
                    Element pubDate_ele = item_ele.getElementsByTag("pubDate").first();
                    if (title_ele != null) {
                        title = title_ele.text().replace("&amp;#34;", "'\'").replaceAll("&#34;", "\'")
                                .replaceAll("&#39;", "\'");
                    }
                    if (link_ele != null) {
                        link = link_ele.text();
                    }
                    if (guid_ele != null) {
                        guid = guid_ele.text();
                    }
                    if (pubDate != null) {
                        pubDate = pubDate_ele.text();
                    }
                    Element elementDes = item_ele.getElementsByTag("description").first();

                    if (elementDes != null) {
                        img = Utils.extractImageUrl(elementDes.text());
                        description_short = Jsoup.parse(elementDes.text()).text().replace("&amp;#34;", "'").replaceAll("&#34;", "'")
                                .replaceAll("&#39;", "'");
                    }

//                    MyLog.Log("title: " + title);
//                    MyLog.Log("link: " + link);
//                    MyLog.Log("guid: " + guid);
//                    MyLog.Log("img: " + img);
//                    MyLog.Log("description_short: " + description_short);
//                    MyLog.Log("pubDate: " + pubDate);
//                    MyLog.Log("------------");
//                    if (!img.isEmpty()) {
                    data.add(new News(title, link, img, description_short, guid, pubDate));
//                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
                MyLog.Log("ex: " + e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(ArrayList<News> ob) {
            super.onPostExecute(ob);
            MyLog.Log("arrayListNew.size: " + ob.size());
            adapter.setData(ob);
            MyOnShowData();
//            XMLDOMParser parser = new XMLDOMParser();
//            Document document = parser.getDocument(s);


//            NodeList nodeList = document.getElementsByTagName("item");
//            NodeList nodeListdescription = document.getElementsByTagName("description");
//            String title = "";
//            String link = "";
//            String img = "";
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                String cdata = nodeListdescription.item(i + 1).getTextContent();
//                img = Utils.extractImageUrl(cdata);
//
//                MyLog.Log("cdata..." + i + ": " + cdata);
//                MyLog.Log("img: " + img + "....." + i);
////                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
////                Matcher matcher = p.matcher(cdata);
////                if (matcher.find()) {
////                    img = matcher.group(1);
////                    MyLog.Log("img: " + img + "....." + i);
////                }
//                Element element = (Element) nodeList.item(i);
//                title = parser.getValue(element, "title");
//                link = parser.getValue(element, "link");
//                MyLog.Log("link: " + link);
//                data.add(new News(img, title));

        }
//            if(data.size()>0)
//
//        {
//            adapter.setData(data);
//        }
//    }
    }
}
