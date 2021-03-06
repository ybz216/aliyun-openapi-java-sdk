/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliyuncs.mts.transform.v20140618;

import java.util.ArrayList;
import java.util.List;

import com.aliyuncs.mts.model.v20140618.QueryVideoSummaryJobListResponse;
import com.aliyuncs.mts.model.v20140618.QueryVideoSummaryJobListResponse.Job;
import com.aliyuncs.mts.model.v20140618.QueryVideoSummaryJobListResponse.Job.Input;
import com.aliyuncs.mts.model.v20140618.QueryVideoSummaryJobListResponse.Job.VideoSummaryResult;
import com.aliyuncs.mts.model.v20140618.QueryVideoSummaryJobListResponse.Job.VideoSummaryResult.OutputFile;
import com.aliyuncs.mts.model.v20140618.QueryVideoSummaryJobListResponse.Job.VideoSummaryResult.VideoSummary;
import com.aliyuncs.transform.UnmarshallerContext;


public class QueryVideoSummaryJobListResponseUnmarshaller {

	public static QueryVideoSummaryJobListResponse unmarshall(QueryVideoSummaryJobListResponse queryVideoSummaryJobListResponse, UnmarshallerContext _ctx) {
		
		queryVideoSummaryJobListResponse.setRequestId(_ctx.stringValue("QueryVideoSummaryJobListResponse.RequestId"));

		List<String> nonExistIds = new ArrayList<String>();
		for (int i = 0; i < _ctx.lengthValue("QueryVideoSummaryJobListResponse.NonExistIds.Length"); i++) {
			nonExistIds.add(_ctx.stringValue("QueryVideoSummaryJobListResponse.NonExistIds["+ i +"]"));
		}
		queryVideoSummaryJobListResponse.setNonExistIds(nonExistIds);

		List<Job> jobList = new ArrayList<Job>();
		for (int i = 0; i < _ctx.lengthValue("QueryVideoSummaryJobListResponse.JobList.Length"); i++) {
			Job job = new Job();
			job.setId(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].Id"));
			job.setUserData(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].UserData"));
			job.setPipelineId(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].PipelineId"));
			job.setState(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].State"));
			job.setCode(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].Code"));
			job.setMessage(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].Message"));
			job.setCreationTime(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].CreationTime"));

			Input input = new Input();
			input.setBucket(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].Input.Bucket"));
			input.setLocation(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].Input.Location"));
			input.setObject(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].Input.Object"));
			job.setInput(input);

			VideoSummaryResult videoSummaryResult = new VideoSummaryResult();

			OutputFile outputFile = new OutputFile();
			outputFile.setBucket(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].VideoSummaryResult.OutputFile.Bucket"));
			outputFile.setLocation(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].VideoSummaryResult.OutputFile.Location"));
			outputFile.setObject(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].VideoSummaryResult.OutputFile.Object"));
			videoSummaryResult.setOutputFile(outputFile);

			List<VideoSummary> videoSummaryList = new ArrayList<VideoSummary>();
			for (int j = 0; j < _ctx.lengthValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].VideoSummaryResult.VideoSummaryList.Length"); j++) {
				VideoSummary videoSummary = new VideoSummary();
				videoSummary.setStartTime(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].VideoSummaryResult.VideoSummaryList["+ j +"].StartTime"));
				videoSummary.setEndTime(_ctx.stringValue("QueryVideoSummaryJobListResponse.JobList["+ i +"].VideoSummaryResult.VideoSummaryList["+ j +"].EndTime"));

				videoSummaryList.add(videoSummary);
			}
			videoSummaryResult.setVideoSummaryList(videoSummaryList);
			job.setVideoSummaryResult(videoSummaryResult);

			jobList.add(job);
		}
		queryVideoSummaryJobListResponse.setJobList(jobList);
	 
	 	return queryVideoSummaryJobListResponse;
	}
}