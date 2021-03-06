package com.tianxing.ui.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tianxing.fscteachersedition.R;
import com.tianxing.presenter.main.ContactsPresenter;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;


/**
 * Created by tianxing on 16/8/1.
 */
public class ContactsExpandableListAdapter implements ExpandableListAdapter {


    private ContactsPresenter presenter;
    private LayoutInflater inflater;
    public ContactsExpandableListAdapter(Context context, ContactsPresenter presenter){
        this.presenter = presenter;
        inflater = LayoutInflater.from(context);
    }


    /**
     * @param observer
     */
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    /**
     * @param observer
     */
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    /**
     * Gets the number of groups.
     *
     * @return the number of groups
     */
    @Override
    public int getGroupCount() {
        return 0;
    }

    /**
     * Gets the number of children in a specified group.
     *
     * @param groupPosition the position of the group for which the children
     *                      count should be returned
     * @return the children count in the specified group
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    /**
     * Gets the data associated with the given group.
     *
     * @param groupPosition the position of the group
     * @return the data child for the specified group
     */
    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    /**
     * Gets the data associated with the given child within the given group.
     *
     * @param groupPosition the position of the group that the child resides in
     * @param childPosition the position of the child with respect to other
     *                      children in the group
     * @return the data of the child
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    /**
     * Gets the ID for the group at the given position. This group ID must be
     * unique across groups. The combined ID (see
     * {@link #getCombinedGroupId(long)}) must be unique across ALL items
     * (groups and all children).
     *
     * @param groupPosition the position of the group for which the ID is wanted
     * @return the ID associated with the group
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * Gets the ID for the given child within the given group. This ID must be
     * unique across all children within the group. The combined ID (see
     * {@link #getCombinedChildId(long, long)}) must be unique across ALL items
     * (groups and all children).
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child within the group for which
     *                      the ID is wanted
     * @return the ID associated with the child
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     * Indicates whether the child and group IDs are stable across changes to the
     * underlying data.
     *
     * @return whether or not the same ID always refers to the same object
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * Gets a View that displays the given group. This View is only for the
     * group--the Views for the group's children will be fetched using
     * {@link #getChildView(int, int, boolean, View, ViewGroup)}.
     *
     * @param groupPosition the position of the group for which the View is
     *                      returned
     * @param isExpanded    whether the group is expanded or collapsed
     * @param convertView   the old view to reuse, if possible. You should check
     *                      that this view is non-null and of an appropriate type before
     *                      using. If it is not possible to convert this view to display
     *                      the correct data, this method can create a new view. It is not
     *                      guaranteed that the convertView will have been previously
     *                      created by
     *                      {@link #getGroupView(int, boolean, View, ViewGroup)}.
     * @param parent        the parent that this view will eventually be attached to
     * @return the View corresponding to the group at the specified position
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHold viewHold;
        if (convertView == null){
            convertView= inflater.inflate(R.layout.listview_contects_header, parent, false);
            viewHold = new GroupViewHold(convertView);
            convertView.setTag(viewHold);
        }else {
            viewHold = (GroupViewHold) convertView.getTag();
        }
        return viewHold.getView();
    }

    /**
     * Gets a View that displays the data for the given child within the given
     * group.
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child (for which the View is
     *                      returned) within the group
     * @param isLastChild   Whether the child is the last child within the group
     * @param convertView   the old view to reuse, if possible. You should check
     *                      that this view is non-null and of an appropriate type before
     *                      using. If it is not possible to convert this view to display
     *                      the correct data, this method can create a new view. It is not
     *                      guaranteed that the convertView will have been previously
     *                      created by
     *                      {@link #getChildView(int, int, boolean, View, ViewGroup)}.
     * @param parent        the parent that this view will eventually be attached to
     * @return the View corresponding to the child at the specified position
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHold viewHold;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.listview_contects_item, parent, false);
            ImageView icon = (ImageView) convertView.findViewById(R.id.imageView_icon);
            Picasso.with(inflater.getContext()).load(R.mipmap.user_icon).transform(new CropCircleTransformation()).into(icon);
            viewHold = new ChildViewHold(convertView);
            convertView.setTag(viewHold);
        }else {
            viewHold = (ChildViewHold) convertView.getTag();
        }
        return viewHold.getView();
    }

    /**
     * Whether the child at the specified position is selectable.
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child within the group
     * @return whether the child is selectable.
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Called when a group is expanded.
     *
     * @param groupPosition The group being expanded.
     */
    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    /**
     * Called when a group is collapsed.
     *
     * @param groupPosition The group being collapsed.
     */
    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    /**
     * Gets an ID for a child that is unique across any item (either group or
     * child) that is in this list. Expandable lists require each item (group or
     * child) to have a unique ID among all children and groups in the list.
     * This method is responsible for returning that unique ID given a child's
     * ID and its group's ID. Furthermore, if {@link #hasStableIds()} is true, the
     * returned ID must be stable as well.
     *
     * @param groupId The ID of the group that contains this child.
     * @param childId The ID of the child.
     * @return The unique (and possibly stable) ID of the child across all
     * groups and children in this list.
     */
    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    /**
     * Gets an ID for a group that is unique across any item (either group or
     * child) that is in this list. Expandable lists require each item (group or
     * child) to have a unique ID among all children and groups in the list.
     * This method is responsible for returning that unique ID given a group's
     * ID. Furthermore, if {@link #hasStableIds()} is true, the returned ID must be
     * stable as well.
     *
     * @param groupId The ID of the group
     * @return The unique (and possibly stable) ID of the group across all
     * groups and children in this list.
     */
    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }


    static class ChildViewHold {
        private View view;
        public ChildViewHold(View view){
            this.view = view;
        }

        public View getView() {
            return view;
        }
    }

    static class GroupViewHold {
        private View view;

        public GroupViewHold(View view){
            this.view = view;
        }

        public View getView() {
            return view;
        }
    }
}
