Laboratorul 6
// method = 1: frame difference
// method = 2: running avg
// method = 3: running avg with select
void movement_detection(int method)
{
	VideoCapture cap("Videos/laboratory.avi");

	Mat frame; // current frame
	Mat gray; // current frame in grayscale
	Mat background; // bkg model

	Mat diff; // abs(gray-background)
	Mat dst; // output

	char op; // key pressed - operation
	int frameNum = -1; // frame counter

	const unsigned char th = 25; // threshold
	const double alpha = 0.05;

	for (;;)
	{
		cap >> frame; // read a frame
		if (frame.empty())
		{
			printf("\nEnd of video file\n");
			break;
		}

		if (++frameNum == 0) // first frame doesnt have a previous
		{
			imshow("src", frame);
		}

		cvtColor(frame, gray, CV_BGR2GRAY);
		GaussianBlur(gray, gray, Size(5, 5), 0.85, 0.85); // remove noise

		dst = Mat::zeros(gray.size(), gray.type());

		if (frameNum > 0)
		{
			double secs = (double)getTickCount();

			absdiff(gray, background, diff);

			if (method == 1)
			{
				background = gray.clone();
			}
			else if (method == 2)
			{
				addWeighted(gray, alpha, background, 1.0 - alpha, 0, background);
			}

			int rows = diff.rows;
			int cols = diff.cols;
			for (int i = 0; i < rows; i++)
			{
				for (int j = 0; j < cols; j++)
				{
					if (diff.at<uchar>(i, j) > th)
					{
						dst.at<uchar>(i, j) = 255;
					}
					else
					{
						if (method == 3)
						{
							background.at<uchar>(i, j) = alpha * gray.at<uchar>(i, j) +
								(1.0 - alpha) * background.at<uchar>(i, j);
						}
					}
				}
			}

			Mat element = getStructuringElement(MORPH_CROSS, Size(3, 3));
			erode(dst, dst, element, Point(-1, -1), 2);
			dilate(dst, dst, element, Point(-1, -1), 2);

			imshow("src", frame);
			imshow("dest", dst);

			secs = ((double)getTickCount() - secs) / getTickFrequency();

			printf("[frame %d]: %.3lf ms\n", frameNum, secs * 1000);
		}
		else
		{
			background = gray.clone();
		}

		op = cvWaitKey(0); // for continuous play
		if (op == 27)
		{
			printf("\nESC pressed\n");
			break;
		}
	}
}
