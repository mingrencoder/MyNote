package file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.androidpn.server.model.User;
import org.androidpn.server.service.UserNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


public interface InformShipSegListenr {
    /**
     * 根据船舶零件的ID号去查询信息
     * @param id
     */
    public void querySegInfo(int id);
}

public interface DisposeShipSegListener {
    
    /**
     * 将对应id的船舶分段放入手指坐标x,y对应的生产场地
     * @param id, groupId, x, y
     */
    public void putUnitIn(int id, int groupId, int x, int y);
}

public interface InformFieldListener {
    public void queryFieldInfo(int id);
}


public interface UserDao extends CrudDao<User> {
    public User getByLoginName(User user);//根据登录名称查询用户
    public long findAllCount(User user);//查询全部用户数目
    public int updatePasswordById(User user);//更新用户密码
    public int updateLoginInfo(User user);//更新登录信息，如：登录IP、登录时间
    public int updateUserInfo(User user);//更新用户信息
}

public interface CrudDao<T> extends BaseDao {
    public T get(T entity);//获取单条数据
    public List<T> findAllList(T entity);//查询所有数据列表
    public int insert(T entity);//插入数据
    public int update(T entity);//更新数据
    public int delete(T entity);//删除数据（一般为逻辑删除，更新del_flag字段为1）
}

public class print {
    
    
    
    public void sendNotificationToUser(boolean isFirst, String sendId, String receiveId, String title,
                            String message,String time, String imageUrl) {
        String id = "";
        if(isFirst){    //若第一次推送数据，则存入数据库
            id = Integer.toHexString(new Random().nextInt());
            User user = userService.getUserByUsername(receiveId);
            if(user != null && user.getActivated()){
                saveNotification(apiKey, username, title, message, uri, id, imageUrl);
            }
        }
        IQ notificationIQ = createNotificationIQ(String uuid, String sendId, String receiveId,
                            String title,String message,String time);   //创建任务IQ
        sendIQ(notificationIQ);     //发送该任务IQ
    }
    
    
    
    
    
    
    
    @Override
    public String getChildElementXML() {
        StringBuilder buf = new StringBuilder();
        //命名空间
        buf.append("<").append("notification").append(" xmlns=\"").append("eisserver:iq:deliverconfirm").append("\">");
        if (uuid != null) {
            buf.append("<uuid>").append(uuid).append("</uuid>");
        }
        buf.append("</").append("notification").append("> ");
        return buf.toString();
    }
    
    //发送消息回执
    DeliverConfirmIQ deliverConfirmIQ = new DeliverConfirmIQ();
    deliverConfirmIQ.setUuid(notificationId);
    deliverConfirmIQ.setType(org.jivesoftware.smack.packet.IQ.Type.SET);
    xmppManager.getConnection().sendPacket(deliverConfirmIQ);
    
    
    //重连时间
    private int waiting() {
        //重连次数超过25
        if (waiting > 25) {
            return 1200;
        }
        //重连次数超过15
        if (waiting > 15) {
            return 600;
        }
        //重连次数不超过10
        return waiting <= 10 ? 10 : 60;
    }
    
    
    
    PacketFilter packetFilter = new AndFilter(new PacketIDFilter(registration.getPacketID()),
                                        new PacketTypeFilter(IQ.class));
    PacketListener packetListener = new PacketListener() {
        public void processPacket(Packet packet) {
            synchronized (xmppManager) {
                if (packet instanceof IQ) {
                    ……
                    } else if (response.getType() == IQ.Type.RESULT) {
                        ……
                        //注册成功
                        isRegisterSuccess = true;
                    }
                }
            }
        }
    };



    //发送注册IQ
    registration.addAttribute("username", newUsername);
    registration.addAttribute("password", newPassword);
    connection.sendPacket(registration);
    
    //连接
    ConnectionConfiguration connConfig =
                        new ConnectionConfiguration(xmppHost, xmppPort);
    XMPPConnection connection = new XMPPConnection(connConfig);
    connection.connect();
    
    
    
    
    
    @SuppressWarnings("unchecked")
    public Future submit(Runnable task) {
        Future result = null;
        if (!notificationService.getExecutorService().isTerminated()
            && !notificationService.getExecutorService().isShutdown()
            && task != null) {
            result = notificationService.getExecutorService().submit(task);
        }
        return result;
    }
    
    
    
    
    
    List<Deposition> depositionList = helper.getDepositionByField(field);
    for (int i = 0; i < depositionList.size(); i++) {
        if (begin > depositionList.get(i).getEnd_date()) {
            continue;
        } else if (end < depositionList.get(i).getBegin_date()) {
            continue;
        } else {
            Toast.makeText(getActivity(), "该区域当前时间段已被占用", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        }
    }
    
    
    
    
    
    
    
    mDragGridView.setmInformFieldListener(new InformFieldListener() {
        @Override
        public void queryFieldInfo(int id) {
            Field field = mFieldList.get(id);
            if (field != null) {
                showDeposition(field);
            }
        }
    });
    
    mFlowlayout.setQueryShipUnitListenr(new InformShipSegListenr() {
        @Override
        public void querySegInfo(int unitId) {
            String name = helper.getSegmentById(unitId).getName();
            String des = helper.getSegmentById(unitId).getDescription();
            List<Field> flist = helper.getFieldListBySegId(unitId);
            String ff = "";
            for (Field f : flist) {
                ff += f.getName() + " ";
            }
            String[] mUnitInfo = new String[]{name, des, ff};
            showInfoDialog(mUnitInfo);
        }
    });
    
    
    
    //读取场地信息
    for (int i = 0; i < mFieldList.size(); i++) {
        HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
        for (int j = 0; j < mSegTypeList.size(); j++) {
            if (mFieldList.get(i).getType() == mSegTypeList.get(j).getId()) {
                itemHashMap.put("item_image", mSegTypeList.get(j).getTypeNum());
                itemHashMap.put("item_text", mFieldList.get(i).getName());
            }
        }
        mFieldsList.add(itemHashMap);
    }
    //读取分段信息
    HashSet<Integer> types = helper.getSegmentTypes();
    int index = 1;
    for (int type : types) {
        LinkedHashMap<Integer, String> mShipUnitVals = new LinkedHashMap<Integer, String>();
        //第一个放置分组名
        mShipUnitVals.put(index, helper.getSegType(type).getDescription());
        for (int i = 1; i <= mSegmentList.size(); i++) {
            if (mSegmentList.get(i - 1).getType() == type) {
                mShipUnitVals.put(new Long(mSegmentList.get(i - 1).getId()).intValue(), mSegmentList.get(i - 1).getName());
            }
        }
        index++;
        mShipSegList.add(mShipUnitVals);
    }
    
    
    
    
    //船舶分段数据结构
    private List<LinkedHashMap<Integer, String>> mShipSegList;
    //场地数据结构
    private List<HashMap<String, Object>> mFieldsList;
    
    private void initFlowLayout() {
        ……
        
        for (int i = 0; i < mShipSegList.size(); i++) {
            // 一行数据，代表一组船舶部件分类
            mShipSegListChild = mShipSegList.get(i);
            Button button = new Button(getActivity());
            button.setId(i);
            // 第一个数据就设为分组名字
            button.setText(mShipSegListChild.get((i + 1)));
            button.setOnClickListener(new OnClickListener() {
                
                @Override
                public void onClick(View v) {
                    //清除原有子View
                    mFlowlayout.removeAllViews();
                    ……
                    LinkedHashMap<Integer, String> s = mShipSegList.get(v.getId());
                    Iterator<Entry<Integer, String>> it = s.entrySet().iterator();
                    // 除去第一个名称元素，并把第一个元素id赋给back
                    int mGroupId = it.next().getKey();
                    s.remove(s.get(mGroupId));
                    while (it.hasNext()) {
                        ToggleButton mtbtn = new ToggleButton(getActivity());
                        ……
                        mFlowlayout.addView(mtbtn, params);
                    }
                    Button mBackBtn = new Button(getActivity());
                    mBackBtn.setId(mGroupId);
                    mBackBtn.setText("返回");
                    mBackBtn.setOnClickListener(new OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                            initFlowLayout();
                        }
                    });
                    mFlowlayout.addView(mBackBtn, params);
                }
            });
            mFlowlayout.addView(button, params);
        }
        
        //没用的
        //mFlowlayout.setDragGridAdapter(mDragAdapter);
        mFlowlayout.setQueryShipUnitListenr(new InformShipSegListenr() {
            
            @Override
            public void querySegInfo(int unitId) {
                // 假设这里是通过unitId获得了部件详细数据
                Log.i("tag", unitId + "");
                String name = helper.getSegmentById(unitId).getName();
                String des = helper.getSegmentById(unitId).getDescription();
                List<Field> flist = helper.getFieldListBySegId(unitId);
                String ff = "";
                for (Field f : flist) {
                    ff += f.getName() + " ";
                }
                String[] mUnitInfo = new String[]{name, des, ff};
                showInfoDialog(mUnitInfo);
            }
            
        });
        mFlowlayout.setmDisposeShipSegListener(new DisposeShipSegListener() {
            
            @Override
            public void putUnitIn(int id, int groupId, int x, int y) {
                
                int areaNum = mDragGridView.pointToPosition(x, y);
                if (areaNum == -1) {
                    Toast.makeText(getActivity(), "请在目标区域内选择", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                Log.i("tag", id + "");
                Log.i("tag", groupId + "");
                Log.i("tag", areaNum + "");
                /***************************************************************************
                 * 根据场地field类型判断是否可以放置
                 */
                
                if (!(String.valueOf(id).substring(0, 1).equals(String.valueOf(mFieldList.get(areaNum).getType())))) {
                    Toast.makeText(getActivity(), "场地类型不符，请挑选合适场地", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                showDisposeDialog(id, groupId, areaNum);
            }
        });
    }
    
    private void initGridView() {
        
        mDragGridView.setAdapter(mDragAdapter);
        
        mDragGridView.setmInformFieldListener(new InformFieldListener() {
            @Override
            public void queryFieldInfo(int id) {
                Log.i(TAG, "field: " + id);
                Field field = mFieldList.get(id);
                if (field != null) {
                    showDeposition(field);
                }
            }
        });
    }
    
    
    
    
    
    
    
    
    UserCustom userCustom = (UserCustom) responseObj;
    for (User u : userCustom.getList()) {
        if (u != null) {
            String path = "http://" + Constants.SERVER_IP + ":8080/EISServer/images/userphoto/";
            Uri uri = Uri.parse(path + u.getUsername() + "/1.png");
            mItemInfoList.add(new ItemInfo(uri, u.getName(), u.getUsername()));
        }
    }
    mListViewInfo.setAdapter(new CheckUserInfoAdapter(LogcheckActivity.this, mItemInfoList));
    
    
    holder.draweeView.setImageURI(bean.getUri());
    
    
    @ResponseBody
    @RequestMapping("/getUsers")
    public UserCustom getUsers(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        User user;
        List<User> listUser = new ArrayList<User>();
        UserCustom userCustom = new UserCustom();
        try {
            List<Relation> list = relationService.findRelation(username);
            for(Relation r : list){
                user = userService.getUserByUsername(r.getUser());
                listUser.add(user);
            }
            userCustom.setList(listUser);
            return userCustom;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    
    
    
    
    
	/**
	 * 用户登录方法
	 * 
	 * @param username
	 * @param password
	 */
	private void login(final String username, String password) {
		RequestParams params = new RequestParams();
		params.put("username", username);
		params.put("password", password);
		CommonOkHttpClient.post(CommonRequest
				.createPostRequest("http://" + Constants.SERVER_IP + ":8080/EISServer/login/signin", params),
				new DisposeDataHandle(new DisposeDataListener() {
					@Override
					public void onSuccess(Object responseObj) {
						Intent intent = new Intent();
						Bundle bundle = new Bundle();
                        bundle.putSerializable("user", ((User) responseObj));
                        // 将用户名密码放入SharedPreferences类中
                        putUserInSp((User) responseObj);
						intent.putExtras(bundle);
						intent.setClass(LoginActivity.this, MainActivity.class);
						// 开启推送通知服务
						serviceManager = new ServiceManager(LoginActivity.this);
						serviceManager.setNotificationIcon(R.drawable.notification);
						serviceManager.startService();
						// 进入主界面
						startActivity(intent);
					}
					@Override
					public void onFailure(Object reasonObj) {
						Toast.makeText(getApplicationContext(), "用户名密码错误！", Toast.LENGTH_SHORT).show();
					}
				}, User.class));
	}

	@ResponseBody
	@RequestMapping("/signin")
	public User signin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			user = userService.getUserByUsername(username);
			if (user != null && user.getActivated()) {
				if (password.equals(user.getPassword())) {
					return user;
				}
			}
		} catch (UserNotFoundException e) {
			return null;
		}
		return null;
	}

	private void handleResponse(Object responseObj) {
		if (responseObj == null) {
			mListener.onFailure(new OkHttpException(NETWORK_ERROR, EMPTY_MSG));
			return;
		}
		try {
            //若转化类型为空，则视为请求成功
			if (mClass == null) {
				mListener.onSuccess(result);
			} else {
                //JSON对象转化
				Gson gson = new Gson();  
				Object obj = gson.fromJson(responseObj.toString(), mClass); 
				if (obj != null) {
					mListener.onSuccess(obj);
				} else {
					mListener.onFailure(new OkHttpException(JSON_ERROR, EMPTY_MSG));
				}
			}

		} catch (Exception e) {
			mListener.onFailure(new OkHttpException(OTHER_ERROR, e.getMessage()));
			e.printStackTrace();
		}
	}

	/Users/jikai/Documents/船舶企业数据/User/100/photo/

	public MyFragmentPagerAdapter(FragmentManager fm,
                            List<Fragment> fragList, List<String> titleList) {
        super(fm);
        this.fragList = fragList;
        this.titleList = titleList;
    }
    
    new Thread(new Runnable() {
        @Override
        public void run() {
            Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentResolver resolver = getContentResolver();
            //通过游标寻找图片格式的文件
            Cursor c = resolver.query(mImageUri, null,
                    MediaStore.Images.Media.MIME_TYPE + "= ? or " + MediaStore.Images.Media.MIME_TYPE + "= ?",
                    new String[] { "image/jpeg", "image/png" }, MediaStore.Images.Media.DATE_MODIFIED);
            //这里存储的是所有扫描过的文件夹
            Set<String> mDirPaths =  new HashSet<String>();
            if(c!=null){
                while(c.moveToNext()){
                    //当前图片的路径
                    String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
                    ……
                    int picCount = parentFile.list(new FilenameFilter() {
                        //因为最终要得到的是图片的数量，所以判断一下遍历的文件是否是图片
                        @Override
                        public boolean accept(File dir, String name) {
                            if(name.endsWith(".jpeg")|| name.endsWith(".jpg")
                               || name.endsWith(".png")){
                                return true;
                            }
                            return false;
                        }
                    }).length;
                    ……
                }
            }
            c.close();
            //通知Handler扫描完成
            mHandler.sendEmptyMessage(DATA_LOADED);
        }
    }).start();
    
    public void handleMessage(android.os.Message msg) {
        if(msg.what == DATA_LOADED){
            progressDialog.dismiss();
            //绑定数据到View中
            data2View();
            //初始化popupwindow
            initPopupWindow();
        }
    };
    
    
    //实现图片加载
    final String mImgPath = mDirPath + "/" + mImgPaths.get(position);
    ImageLoader.getInstance(3, Type.LIFO).loadImage(mImgPath, holder.mImg);
    
    private Runnable getTask() {
        if (mType == Type.FIFO) {
            return mTaskQueue.removeFirst();
        } else if (mType == Type.LIFO) {
            return mTaskQueue.removeLast();
        }
        return null;
    }
    
    public void loadImage(final String path, final ImageView imageView) {
        imageView.setTag(path);
        if (mUIHandler == null) {
            mUIHandler = (Handler) handleMessage(msg) → {
                    // 获得图片并设置图片
                    ImgBeanHolder holder = (ImgBeanHolder) msg.obj;
                    Bitmap bm = holder.bitmap;
                    String path = holder.path;
                    ImageView img = holder.imageView;
                    // 将最初loadImage方法时传入的ImageView对象与回调的对象的路径进行比对，并设置图片
                    if (img.getTag().toString().equals(path)) {
                        img.setImageBitmap(bm);
                    }
                }
            };
        }
        Bitmap bm = getBitmapFromLrucache(path);
        if (bm != null) {
            refreshBitmap(path, imageView, bm);
        } else {
            addTask(() → {
                    Bitmap bm = decodeSampledBitmapFromPath(path, imageSize);
                    if(bm!=null){
                        addBitmapToLrucache(path, bm);
                        refreshBitmap(path, imageView, bm);
                    }
                    mSemaphorePoolThread.release();
                }
            });
        }
    }

public ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<String, String>();
public ConcurrentHashMap<String, Object> fileParams = new ConcurrentHashMap<String, Object>();

File f = new File(pic, filename);
FileOutputStream fos = new FileOutputStream(f);
InputStream is = item.getInputStream();
int len = 0;
byte[] buff = new byte[1024];
while((len = is.read(buff)) != -1){
    System.out.println(buff.toString());
    fos.write(buff, 0, len);
}
fos.flush();
fos.close();
is.close();




















}
