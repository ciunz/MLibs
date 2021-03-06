package com.iapps.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iapps.common_library.R;
import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.views.ImageViewLoader;

import java.util.List;

/**
 * Created by marcelsantoso.
 * <p>
 * 8/31/16
 */
public abstract class BaseRecyclerToolbarAdapter extends BaseRecyclerAdapter {
    private int viewMode = 1;
    private GridLayoutManager layoutManager;
    private ArrayAdapter<String> spinnerAdapter;
    protected String contentType;
    private RecyclerInterface recyclerInterface;

    public BaseRecyclerToolbarAdapter(Context context, List<?> items) {
        super(context, items, 0);
        viewMode = defaultViewMode();
    }

    public BaseRecyclerToolbarAdapter(Context context, List<?> items, RecyclerInterface recyclerInterface) {
        super(context, items, 0);
        viewMode = defaultViewMode();
        this.recyclerInterface = recyclerInterface;
    }

    public BaseRecyclerToolbarAdapter(Context context, List<?> items, String contentType) {
        super(context, items, 0);
        viewMode = defaultViewMode();
        this.contentType = contentType;
    }

    public BaseRecyclerToolbarAdapter setLayoutManager(GridLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        return this;
    }

    public int getViewMode() {
        return viewMode;
    }

    @Override
    public boolean showHeader() {
        return true;
    }

    public boolean showSort() {
        return true;
    }

    @Override
    public int headerLayout() {
        return R.layout.header_tool;
    }

    @Override
    public int cellLayout() {
        return R.layout.cell_tool;
    }

    public int defaultViewMode() {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return new HeaderHolder(v);
    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {
        HeaderHolder holder = (HeaderHolder) objectHolder;

        holder.rlHeader.setVisibility(showHeader() ? View.VISIBLE : View.GONE);

        if (showSort()) {
            holder.tvSort.setVisibility(View.VISIBLE);
            holder.spinner.setVisibility(View.VISIBLE);
        } else {
            holder.tvSort.setVisibility(View.GONE);
            holder.spinner.setVisibility(View.GONE);
        }

        setupHeaderTool(this, holder.spinner, holder.rg);

        // Set default check
        switch (getViewMode()) {
            case 1:
                holder.rb1.setChecked(true);
                break;

            case 2:
                holder.rb2.setChecked(true);
                break;

            case 3:
                holder.rb3.setChecked(true);
                break;

            case 4:
                holder.rb4.setVisibility(View.VISIBLE);
                holder.rb4.setChecked(true);
                break;
        }
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, final int position) {
        ToolHolder holder = (ToolHolder) objectHolder;

        holder.layout1.setVisibility(View.GONE);
        holder.layout2.setVisibility(View.GONE);
        holder.layout3.setVisibility(View.GONE);
        holder.layout4.setVisibility(View.GONE);
        Log.d("VIEW MODE ", "" + getViewMode());
        switch (getViewMode()) {
            case 1:
                holder.layout1.setVisibility(View.VISIBLE);
                setView(holder.tvTitle, holder.tvPrice, holder.img, position);
                break;

            case 2:
                holder.layout2.setVisibility(View.VISIBLE);
                setView(holder.tvTitle2, holder.tvPrice2, holder.img2, position);
                break;

            case 3:
                holder.layout3.setVisibility(View.VISIBLE);
                setView(holder.tvTitle3, holder.tvPrice3, holder.img3, position);
                break;

            case 4:
                holder.layout4.setVisibility(View.VISIBLE);
                setView(holder.tvTitle4, holder.tvPrice4, holder.img4, position);
                break;

            default:
                holder.layout1.setVisibility(View.VISIBLE);
                setView(holder.tvTitle, holder.tvPrice, holder.img, position);
                break;
        }

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemSelected(position - 1);
            }
        });
    }

    public abstract void setView(TextView tvTitle, TextView tvPrice, ImageViewLoader img, int position);

    protected void setupHeaderTool(final BaseRecyclerAdapter adapter, final AppCompatSpinner spinner, RadioGroup rg) {
        // Setup spinner
        if (showSort()) {
            if (spinnerAdapter == null) {
                spinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,
                        sortItemList());
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(spinnerAdapter);
            }

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //                if (spinner.getSelectedItemPosition() != position)
                    handleItemSelected(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

        // Setup radio group
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb1) {
                    Log.d("CHANGE VIEW", "To 1");
                    onChangeView1();
                } else if (checkedId == R.id.rb2) {
                    Log.d("CHANGE VIEW", "To 2");
                    onChangeView2();
                } else if (checkedId == R.id.rb3) {
                    Log.d("CHANGE VIEW", "To 3");
                    onChangeView3();
                } else if (checkedId == R.id.rb4) {
                    Log.d("CHANGE VIEW", "To 4");
                    onChangeView4();
                }

                if (layoutManager == null) {
                    BaseHelper.showAlert(getContext(), "Please set Recycler Layout Manager");
                    return;
                }

                layoutManager.setSpanCount(getNumGrid());
                layoutManager.requestLayout();

                try {
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {

                }
            }
        });
    }

    protected boolean showToolbar() {
        return true;
    }

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new ToolHolder(v);
    }

    // Change view
    public void onChangeView1() {
        viewMode = 1;
        setNumGrid(1);
    }

    public void onChangeView2() {
        viewMode = 2;
        setNumGrid(2);
    }

    public void onChangeView3() {
        viewMode = 3;
        setNumGrid(1);
    }

    public void onChangeView4() {
        viewMode = 4;
        setNumGrid(3);
    }

    // Sort
    public String[] sortItemList() {
        return new String[]{"Featured", "Posting Date", "Name: A-Z", "Name: Z-A", "Price: Low to High",
                "Price: High to Low"};
    }

    public void handleItemSelected(int position) {
        switch (position) {
            case 0:
                onSortDefault();
                break;

            case 1:
                onSortTerbaru();
                break;

            case 2:
                onSortAlfabet();
                break;

            case 3:
                onSortAlfabetDesc();
                break;

            case 4:
                onSortTermurah();
                break;

            case 5:
                onSortTermahal();
                break;
        }
    }

    public void onSortTerbaru() {
        if (recyclerInterface != null)
            recyclerInterface.onSortTerbaru();
    }

    public void onSortAlfabet() {

        if (recyclerInterface != null)
            recyclerInterface.onSortAlfabet();
    }

    public void onSortAlfabetDesc() {

        if (recyclerInterface != null)
            recyclerInterface.onSortAlfabetDesc();
    }

    public void onSortTermurah() {

        if (recyclerInterface != null)
            recyclerInterface.onSortTermurah();
    }

    public void onSortTermahal() {
        if (recyclerInterface != null)
            recyclerInterface.onSortTermahal();
    }

    public void onSortDefault() {

        if (recyclerInterface != null)
            recyclerInterface.onSortDefault();
    }

    public class HeaderHolder extends RecyclerView.ViewHolder {
        public RelativeLayout rlHeader;
        public AppCompatSpinner spinner;
        public RadioGroup rg;
        public RadioButton rb1, rb2, rb3, rb4;
        public TextView tvSort;

        public HeaderHolder(View itemView) {
            super(itemView);

            rlHeader = (RelativeLayout) itemView.findViewById(R.id.rlHeader);
            rg = (RadioGroup) itemView.findViewById(R.id.rg);
            spinner = (AppCompatSpinner) itemView.findViewById(R.id.spinSort);
            rb1 = (RadioButton) itemView.findViewById(R.id.rb1);
            rb2 = (RadioButton) itemView.findViewById(R.id.rb2);
            rb3 = (RadioButton) itemView.findViewById(R.id.rb3);
            rb4 = (RadioButton) itemView.findViewById(R.id.rb4);
            tvSort = (TextView) itemView.findViewById(R.id.tvSort);
        }
    }

    public class ToolHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvTitle2, tvTitle3, tvTitle4, tvPrice, tvPrice2, tvPrice3, tvPrice4;
        public ImageViewLoader img, img2, img3, img4;
        public View layout1, layout2, layout3, layout4, parentView;

        public ToolHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            img = (ImageViewLoader) itemView.findViewById(R.id.img);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);

            tvTitle2 = (TextView) itemView.findViewById(R.id.tvTitle2);
            img2 = (ImageViewLoader) itemView.findViewById(R.id.img2);
            tvPrice2 = (TextView) itemView.findViewById(R.id.tvPrice2);

            tvTitle3 = (TextView) itemView.findViewById(R.id.tvTitle3);
            img3 = (ImageViewLoader) itemView.findViewById(R.id.img3);
            tvPrice3 = (TextView) itemView.findViewById(R.id.tvPrice3);

            tvTitle4 = (TextView) itemView.findViewById(R.id.tvTitle4);
            img4 = (ImageViewLoader) itemView.findViewById(R.id.img4);
            tvPrice4 = (TextView) itemView.findViewById(R.id.tvPrice4);

            layout1 = itemView.findViewById(R.id.layout1);
            layout2 = itemView.findViewById(R.id.layout2);
            layout3 = itemView.findViewById(R.id.layout3);
            layout4 = itemView.findViewById(R.id.layout4);
            parentView = itemView.findViewById(R.id.parentView);
        }
    }

    public interface RecyclerInterface {
        void onSortTerbaru();

        public void onSortAlfabet();

        public void onSortAlfabetDesc();

        public void onSortTermurah();

        public void onSortTermahal();

        public void onSortDefault();
    }
}
